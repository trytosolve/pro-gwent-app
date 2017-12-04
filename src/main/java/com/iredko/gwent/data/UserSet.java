package com.iredko.gwent.data;

import com.iredko.gwent.models.User;

import java.util.Set;

public class UserSet {
    Set<User> users;

    public void addUser(User user) throws Exception {
        if (users.contains(user)) {
            throw new Exception("Пользователь уже существует");
        } else {
            users.add(user);
        }
    }
}
