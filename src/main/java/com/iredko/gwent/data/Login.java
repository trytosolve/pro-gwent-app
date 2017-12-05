package com.iredko.gwent.data;

import com.iredko.gwent.models.User;


/*
Клас авторизации пользователя в системе
 */
/*
TODO: очень странный подход к реализации логина.
Более "обычный" подход - делать в приложении компоненты по принципу того как это делается в например автомобилях.
У тебя там есть компоненты "Двигатель", "Тормоза", "Коробка переключения передач", но не "спаливание топлива", "торможение", "управление ходовой".

Компоненты обычно называются по принципу "кто/что" как название, а не как процесс.
Обычно к именам классов с бизнес-логикой добавляют суффиксы под назначение класса, например

-Manager -Handler -Controller (управление чем-то, каким то ресурсом или процессом)
-Provider (предоставляет доступ к чему-то, напр. какой-нибудь ConfigProvider будет иметь какой-нибудь метод Config get() и отдавать вычитанный откуда то конфиг)
-Repository -DAO (представляет собой хранилище каких-то данных, например NewsList более принято называть NewsRepository; название DAO идет от Data Access Object)
и т.д.

PS смотри класс SecurityManager рядом - это то как бы это сделал я.
 */
public class Login {

    private User user;

    public Login(User user) {
        this.user = user;
    }

    //TODO идея через ексепшны вполне хорошая, но тогда надо обьявлять отдельный тип ексепшна под ситуацию и выбрасывать их
    /*
    Пример: создать 2 типа ексепшнов - NoSuchUserException и WrongPasswordException.
    - делаешь public void login() throws NoSuchUserException, WrongPasswordException

    в таком случае в момент вызова нужно будет писать что-то вроде
    try {
    ....
    login.login();
    } catch(NoSuchUserExeption e) {
     // ... тут мы обрабатуем кейс когда юзер не найден
    } catch(WrongPasswordException e2) {
     // .... тут мы обрабатуем кейс когда пароль не правильный
    }

    НО более лучшим решением было бы наверное сделать
    enum LoginResult { LOGIN_OK, NO_SUCH_USER, WRONG_PASSWORD}
    и возвращать его как результат (результат попытки логина)
    и тогда вызывать метод
    LoginResult result = login.login();
    switch(result) {
        case LOGIN_OK: .... break;
        case NO_SUCH_USER: .... break;
        case WRONG_PASSWORD: .... break;
    }
     */
    public void login() throws Exception {
        if (!UserMap.userMap.containsKey(user.getName())) {
            throw new Exception("Данного пользователя не существует!");
        } else {
            if (!UserMap.userMap.get(user.getName()).equals(user.getPassword())) {
                throw new Exception("Не верный пароль!");
            }
        }
    }
}
