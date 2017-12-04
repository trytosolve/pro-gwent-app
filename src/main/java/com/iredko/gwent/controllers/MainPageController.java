package com.iredko.gwent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMain(HttpSession httpSession, ModelAndView model) {
        model.addObject("session",httpSession);
        model.setViewName("mainPage");
        return model;
    }
}
