
package com.iredko.gwent.controllers;

import com.iredko.gwent.models.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/newsCreator")
public class NewsCreatorController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showNewsCreatorPage(ModelAndView model,News news) {
        model.addObject("news",news);
        model.setViewName("newsCreator");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewsToRepo(ModelAndView model, News news) {
        model.addObject("news",news);
        model.setViewName("newsCreator");
        return model;
    }
}