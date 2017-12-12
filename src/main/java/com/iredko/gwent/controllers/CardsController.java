package com.iredko.gwent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/cards")
public class CardsController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCards(ModelAndView model) {
        model.setViewName("cardsPage");
        return model;
    }
}
