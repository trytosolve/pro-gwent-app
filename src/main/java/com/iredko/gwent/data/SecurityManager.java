package com.iredko.gwent.data;

import com.iredko.gwent.models.User;
import org.springframework.stereotype.Component;

/**
 * Итого мы имеем общую абстракцию занимающуюся управлением юзерами.
 * Метод для создания, метод для логина
 */

@Component
public class SecurityManager {
    UserRepository userRepository;

    public SecurityManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public String checkUserIN(String login, String pass) throws Exception {
//        User user = userRepository.getUserByLogin(login);
//        if (user.getLogin()==null) {
//            return false;
//        } else {
//            return LoginResult.WRONG_PASSWORD;
//        }
//    }
//
//    public CreationAccountResult createAccount(String login,String email,String password) throws Exception {
//        User user = userRepository.getUserByLogin(login);
//        if (user.getLogin() != null) {
//            return CreationAccountResult.LOGIN_IN_USE;
//        } else {
//            userRepository.addUserToRepository(login,email,password);
//            return CreationAccountResult.REGITRATION_OK;
//        }
//    }
}
