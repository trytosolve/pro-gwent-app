package com.iredko.gwent.data;

import com.iredko.gwent.models.User;
/*
Клас авторизации пользователя в системе
 */
public class Login {

    private User user;

    public Login(User user) {
        this.user = user;
    }

    public void login() throws Exception {
        if (!UserMap.userMap.containsKey(user.getName())) {
            throw new Exception("Данного пользователя не существует!");
        } else {
            if (!UserMap.userMap.get(user.getName()).equals(user.getPassword())) {
                throw new Exception("Не верный пароль!");
            }
        }
    }
}
