package com.iredko.gwent.controllers;

import com.iredko.gwent.models.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMain(ModelAndView model) {
        model.setViewName("mainPage");
        return model;
    }
}
