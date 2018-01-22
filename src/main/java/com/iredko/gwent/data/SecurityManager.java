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

    public boolean checkUserPassword(String userLogin,String userPassword){ //TODO check воообще довольно кривое слово для названия метода.
        //TODO уж либо checkUserPasswordIsCorrect, либо просто passwordIsCorrect / passwordMatchesToSaved
        User user = userRepository.getUserByLogin(userLogin);
        //TODO вообще все ок, но это можно упростить и написать:
        // TODO return userPassword.equals(user.getPassword())
        if (!user.getPassword().equals(userPassword)) {
            return false;
        }
        return true;
    }

    //TODO секьюрити менеджер сейвит в репозиторий. Почему вдруг ToBD (и да, не BD а DB - DataBase :) ) Просто saveUser
    public void addUserToBD(String userLogin,String userPassword,String userEmail) {
        userRepository.addUserToRepository(userLogin,userEmail,userPassword);
    }

    //TODO то же что с сейвЮзерТуДиби. Просто findUser.
    // TODO Кстати зачастую более лучше придумывать имена методов без get. Ибо getSomething при чтении воспринимается как обычный геттер, а не как что-то что потенциально лезет в базу/сеть/файлы
    public User getUserFromBD(String userLogin) {
       return userRepository.getUserByLogin(userLogin);
    }
}
