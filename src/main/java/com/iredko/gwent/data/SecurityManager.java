package com.iredko.gwent.data;

import com.iredko.gwent.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Итого мы имеем общую абстракцию занимающуюся управлением юзерами.
 * Метод для создания, метод для логина
 */
public class SecurityManager {
    private final Map<String, String> usersMap = new HashMap<>(); // в начале работы пустой

    public void login(User user) throws Exception {
        if (!usersMap.containsKey(user.getName())) {
            throw new Exception("Данного пользователя не существует!");
        } else {
            if (!usersMap.get(user.getName()).equals(user.getPassword())) {
                throw new Exception("Не верный пароль!");
            }
        }
    }

    public void createAccount(User user) throws Exception {
        if (usersMap.containsKey(user.getName())) {
            throw new Exception("Данный пользователь уже существует!");
        } else {
            usersMap.put(user.getName(), user.getPassword());
        }
    }
}
