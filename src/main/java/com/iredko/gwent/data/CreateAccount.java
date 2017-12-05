package com.iredko.gwent.data;

import com.iredko.gwent.models.User;

/*
Класс для добавления нового пользователя
 */

public class CreateAccount {
    private User user;

    public CreateAccount(User user) {
        this.user = user;
    }

    public void newAccount() throws Exception {
        if (UserMap.userMap.containsKey(user.getName())) {
            throw new Exception("Данный пользователь уже существует!");
        } else {
            UserMap.userMap.put(user.getName(), user.getPassword());
        }
    }
}
