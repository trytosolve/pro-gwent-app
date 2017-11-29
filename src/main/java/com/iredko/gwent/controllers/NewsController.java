package com.iredko.gwent.controllers;

import com.iredko.gwent.data.NewsList;
import com.iredko.gwent.models.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final NewsList newsList;

    public NewsController(NewsList newsList) {
        this.newsList = newsList;
    }

    @RequestMapping(method = RequestMethod.GET)

    public ModelAndView getMain(ModelAndView model) throws IOException {
        model.addObject("newsList", newsList.getAll());
        model.setViewName("newsPage");
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getNews(@PathVariable int id, ModelAndView model) {
        model.addObject("text", newsList.getNews(id).getText());
        model.setViewName("newsPageById");
        return model;
    }

}
