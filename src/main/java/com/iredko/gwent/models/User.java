package com.iredko.gwent.models;

import sun.security.util.Password;

public class User {
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

}
