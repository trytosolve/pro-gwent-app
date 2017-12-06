package com.iredko.gwent.data;

import com.iredko.gwent.models.User;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserRepository {

    DbParams dbParams;

    public UserRepository(DbParams dbParams) {
        this.dbParams = dbParams;
    }

    public User getUserByLogin(String login) {
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection conn= DriverManager.getConnection(dbParams.getUrl(),dbParams.getUsername(),dbParams.getPassword())) {
            String sql = "select login,password,email,logintime " +
                    "from webapp.users where login = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,login);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setLastlogin(rs.getDate("logintime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUserToRepository(String login,String email,String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(dbParams.getUrl(),dbParams.getUsername(),dbParams.getPassword())){
            String sql= "insert into webapp.users (login,password,email)" +
                    "VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2,password);
            stmt.setString(3, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
