
package com.iredko.gwent.controllers;

import com.iredko.gwent.DAO.NewsDAO;
import com.iredko.gwent.models.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping(path = "/newsCreator")
public class NewsCreatorController {

    private NewsDAO newsDAO;

    public NewsCreatorController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showNewsCreatorPage(ModelAndView model,News news) {
        model.addObject("news",news);
        model.setViewName("newsCreator");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewsToRepo(ModelAndView model, News news) {
        news.setCreateDateNews(LocalDateTime.now());
        model.addObject("news",news);
        newsDAO.insertNews(news);
        model.setViewName("newsCreator");
        return model;
    }
}