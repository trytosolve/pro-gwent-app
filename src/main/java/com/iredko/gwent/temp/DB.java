package com.iredko.gwent.temp;

import java.sql.*;
import java.util.Date;

public class DB {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "powerpower13";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt;
        String query = "select ID,Name,CountryCode,District,Population " +
                "from world.city where Population>1000000 ORDER BY NAME ";
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String countrycode = rs.getString("CountryCode");
                String district = rs.getString("District");
                int population = rs.getInt("Population");
                System.out.println(id+"\t"+name+"\t"+countrycode+"\t"+district+"\t"
                + population);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(new Date().toString());
    }
}
