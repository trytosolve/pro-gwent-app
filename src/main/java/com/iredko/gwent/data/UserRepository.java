package com.iredko.gwent.data;

import com.iredko.gwent.models.DbParams;
import com.iredko.gwent.models.User;
import com.iredko.gwent.temp.DB;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class UserRepository {

    DbParams dbParams;

    public UserRepository(DbParams dbParams) {
        this.dbParams = dbParams;
    }

    public User getUserByLogin(String login) {
        try(Connection conn= DriverManager.getConnection(dbParams.getUrl(),dbParams.getUsername(),dbParams.getPassword())) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

}
