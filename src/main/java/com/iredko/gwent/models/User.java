package com.iredko.gwent.models;

import sun.security.util.Password;

public class User {
    public User(String name, Password password) {
        this.name = name;
        this.password = password;
    }

    private String  name;
    private Password password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
