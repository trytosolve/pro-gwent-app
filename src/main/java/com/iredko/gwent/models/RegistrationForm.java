package com.iredko.gwent.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class RegistrationForm{

        @Size(min = 4,max = 15)
        @NotEmpty
        String userLogin;

        @Size(min = 8,max = 15)
        @NotEmpty
        String userPassword;

        @Email
        @NotEmpty
        String userEmail;

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

        public String getUserEmail() {
                return userEmail;
        }

        public void setUserEmail(String userEmail) {
                this.userEmail = userEmail;
        }
}
