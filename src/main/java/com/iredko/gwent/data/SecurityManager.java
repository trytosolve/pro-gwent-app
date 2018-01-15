package com.iredko.gwent.data;

import com.iredko.gwent.models.LoginForm;
import com.iredko.gwent.models.RegistrationForm;
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

    public boolean checkUserPassword(String userLogin,String userPassword){
        User user = userRepository.getUserByLogin(userLogin);
        if (!user.getPassword().equals(userPassword)) {
            return false;
        }
        return true;
    }

    public void addUserToBD(String userLogin,String userPassword,String userEmail) {
        userRepository.addUserToRepository(userLogin,userEmail,userPassword);
    }

    public User getUserFromBD(String userLogin) {
       return userRepository.getUserByLogin(userLogin);
    }
}
