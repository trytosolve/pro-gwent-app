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

    public boolean userExists(String userLogin) {
        User user = userRepository.getUserByLogin(userLogin);
        if (user.getLogin() == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean passwordIsCorrect(String userLogin, String userPassword){
        User user = userRepository.getUserByLogin(userLogin);
        //TODO вообще все ок, но это можно упростить и написать:
        // TODO return userPassword.equals(user.getPassword())
        if (!user.getPassword().equals(userPassword)) {
            return false;
        }
        return true;
    }

    public void saveUser(String userLogin,String userPassword,String userEmail) {
        userRepository.addUserToRepository(userLogin,userPassword,userEmail);
    }

    public User findUser(String userLogin) {
       return userRepository.getUserByLogin(userLogin);
    }
}
