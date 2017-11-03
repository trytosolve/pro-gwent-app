package com.iredko.gwent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMain(ModelAndView model) {
        model.addObject("text", "Добро пожаловать!");
        model.setViewName("mainPage");
        return model;
    }
}
