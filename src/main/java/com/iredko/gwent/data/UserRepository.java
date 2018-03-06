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
        //TODO этот кусок кода у тебя повторяется 2 раза точь-в-точь. Что если вырезать его в отдельный метод loadDriver()? :)
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find com.mysql.jdbc.Driver",e);
        }
        try(Connection conn= DriverManager.getConnection(dbParams.getUrl(),dbParams.getUsername(),dbParams.getPassword())) {
            String sql = "select id,login,password,email,logintime " +
                    "from webapp.users where login = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,login);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setLastlogin(rs.getDate("logintime"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get account from database", e);
        }
        return user;
    }

    public void addUserToRepository(String login,String password,String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find com.mysql.jdbc.Driver",e);
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
            throw new RuntimeException("Cannot create account in database", e);
        }

    }
}
