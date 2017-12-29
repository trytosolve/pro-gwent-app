package com.iredko.gwent.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class LogginForm {

    @Size(min = 4,max = 15)
    @NotEmpty
    String userLogin;

    @Size(min = 8,max = 15)
    @NotEmpty
    String userPassword;

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
