package com.iredko.gwent.controllers;

import com.iredko.gwent.data.UserSet;
import com.iredko.gwent.models.User;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/login")
public class LoginController {

    UserSet userSet = new UserSet();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLogin(HttpSession httpSession,ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(path = "/reg", method = RequestMethod.POST)
    public ModelAndView reqAction(HttpSession httpSession,ModelAndView model,
    @RequestParam("userid") String name,@RequestParam("pwd") String pass) throws Exception {
        User newUser = new User(name,pass);
        userSet.addUser(newUser);
        httpSession.setAttribute("USER",newUser);
        model.addObject("user", name);
        model.setViewName("reqActPage");
        return model;
    }
}
