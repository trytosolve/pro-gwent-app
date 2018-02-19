package com.iredko.gwent.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class LoginForm {
    @Size(min=2,max=16)
    String userLogin; //TODO private. Ты по идее не хочешь чтобы кто-либо его менял не через сеттер

    @NotEmpty
    String userPassword; //TODO private. Ты по идее не хочешь чтобы кто-либо его менял не через сеттер

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
