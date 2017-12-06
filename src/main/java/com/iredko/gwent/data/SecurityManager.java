package com.iredko.gwent.data;

import com.iredko.gwent.models.User;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Итого мы имеем общую абстракцию занимающуюся управлением юзерами.
 * Метод для создания, метод для логина
 */

@Component
public class SecurityManager {
    private final Map<String, String> usersMap = null;

    public LoginResult login(String login, String pass) throws Exception {

        return null;
    }

    public CreationAccountResult createAccount(String login,String email,String password) throws Exception {
//        if (usersMap.containsKey(user.getName())) {
//            throw new Exception("Данный пользователь уже существует!");
//        } else {
//            usersMap.put(user.getName(), user.getPassword());
//        }
        return null;
    }

    public void authorizationCheck(String pass,User user) {

    }
}
