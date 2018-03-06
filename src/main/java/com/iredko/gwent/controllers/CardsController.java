package com.iredko.gwent.controllers;

import com.iredko.gwent.data.CardFaction;
import com.iredko.gwent.data.CardRepository;
import com.iredko.gwent.data.CardType;
import com.iredko.gwent.models.SearchFilter;
import com.iredko.gwent.models.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(path = "/cards")
public class CardsController {
    private CardRepository cardRepository;

    public CardsController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCardsLibrary(ModelAndView model, SearchForm searchForm) {
        model.addObject("searchForm", searchForm);
        SearchFilter searchFilter = new SearchFilter();
        model.addObject("cardList", cardRepository.getCardList(searchFilter));
        model.addObject("possibleTypes", CardType.values());
        model.addObject("possibleFactions", CardFaction.values());
        model.setViewName("cardsPage");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView searchCardsLibrary(ModelAndView model, SearchForm searchForm) {
        model.addObject("searchForm", searchForm);
        SearchFilter searchFilter = new SearchFilter(searchForm.getSearchParam(), searchForm.getTypesList(),
                searchForm.getFactionsList());
        model.addObject("cardList", cardRepository.getCardList(searchFilter));
        model.addObject("possibleTypes", CardType.values());
        model.addObject("possibleFactions", CardFaction.values());
        model.setViewName("cardsPage");
        return model;
    }
}
