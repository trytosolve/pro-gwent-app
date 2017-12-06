package com.iredko.gwent.models;

import com.iredko.gwent.temp.DB;
import org.springframework.stereotype.Component;
import sun.security.util.Password;

import java.sql.*;

@Component
public class User {

    private String  login;
    private String password;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return login;
    }

    public void setName(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //---------------------------------------------------------------------
//        public void createUser(String name, String password, String email, Date createTime) {
//        Connection conn;
//        try {
//            conn  = DriverManager.getConnection(DB.URL,DB.USERNAME,DB.PASSWORD);
//            String sql= "insert into webapp.users (Name,CountryCode,District,Population)" +
//                    "VALUES(?,?,?,?)";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, name);
//            stmt.setString(2,password);
//            stmt.setString(3, email);
//            stmt.setDate(4,createTime);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
