package com.iredko.gwent.controllers;

import com.iredko.gwent.data.NewsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final NewsDAO newsDAO;

    public NewsController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllNews(ModelAndView model) {
        model.addObject("newsList", newsDAO.selectAll());
        model.setViewName("newsPage");
        return model;
    }

    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public ModelAndView getNews(@PathVariable int id, ModelAndView model) {
        model.addObject("news", newsDAO.selectById(id));
        model.setViewName("newsPageById");
        return model;
    }

}
