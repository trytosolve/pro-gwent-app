package com.iredko.gwent.controllers;

import com.iredko.gwent.data.Card;
import com.iredko.gwent.data.CardRepository;
import com.iredko.gwent.data.DbParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/cards")
public class CardsController {
    CardRepository cardRepository;

    public CardsController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCards(ModelAndView model) {
        model.addObject("cardList", cardRepository.getCardList());
        model.setViewName("cardsPage");
        return model;
    }
}
