package com.iredko.gwent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLogin(ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(path = "/reg", method = RequestMethod.POST)
    public ModelAndView reqAction(ModelAndView model) {
        model.setViewName("reqActPage");
        return model;
    }
}
