package com.iredko.gwent.models;

import com.iredko.gwent.temp.DB;
import sun.security.util.Password;

import java.sql.*;

public class User {
    Connection conn;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private String  name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //---------------------------------------------------------------------
/*        public void createUser(String name, String password, String email, Date createTime) {
        try {
            conn  = DriverManager.getConnection(DB.URL,DB.USERNAME,DB.PASSWORD);
            String insert = "insert into webapp.users (Name,CountryCode,District,Population)" +
                    "VALUES(?,?,?,?)";
            Statement stmt = conn.prepareStatement(insert);
            stmt.set

//            String query = "select ID,Name,CountryCode,District,Population " +
//                    "from world.city where Population>1000000 ORDER BY NAME ";

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/

}
