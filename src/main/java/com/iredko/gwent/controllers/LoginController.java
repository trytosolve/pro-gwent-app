package com.iredko.gwent.controllers;

import com.iredko.gwent.data.Login;
import com.iredko.gwent.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    Login login; // TODO почему это - поле?

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLogin(HttpSession httpSession,ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(path = "/reg", method = RequestMethod.POST)
    public ModelAndView reqAction(HttpSession httpSession,ModelAndView model,
    @RequestParam("userid") String name,@RequestParam("pwd") String pass) throws Exception {
        User user = new User(name,pass);
        // TODO как я уже говорил ранее - использование new посреди бизнес логики - всегда признак что что-то не так (исключение new на классах JDK - листы мапы даты и т.д.)
        login = new Login(user);
        login.login();
        httpSession.setAttribute("USER",user);
        model.addObject("user", name);
        model.setViewName("reqActPage");
        return model;
    }
}
