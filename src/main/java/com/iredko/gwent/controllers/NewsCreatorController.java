
package com.iredko.gwent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/newsCreator")
public class NewsCreatorController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showNewsCreatorPage(ModelAndView model) {
        model.setViewName("newsCreator");
        return model;
    }
}