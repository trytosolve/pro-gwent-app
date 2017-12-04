package com.iredko.gwent.data;

import com.iredko.gwent.models.User;

import java.util.HashSet;
import java.util.Set;

public class UserSet {
    public static Set<User> users = new HashSet<>();

    public void addUser(User user) throws Exception {
        if (users.contains(user)) {
            throw new Exception("Пользователь уже существует");
        } else {
            users.add(user);
        }
    }
}
