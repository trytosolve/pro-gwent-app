package com.iredko.gwent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/accountPage")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAccountPage(ModelAndView model) {
        model.setViewName("accountPage");
        return model;
    }
}
