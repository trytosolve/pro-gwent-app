package com.iredko.gwent.Controllers;

import com.iredko.gwent.Models.News;
import com.iredko.gwent.Models.NewsMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMain(ModelAndView model) throws IOException {
        Map map = (Map) getNewsMap();
        model.setViewName("newsPage");
        return model;
    }

    public NewsMap getNewsMap() throws IOException {
        NewsMap newsMap = new NewsMap();
        newsMap.addNews(new News("D:/1.txt",01,01,2010));
        newsMap.addNews(new News("D:/2.txt",02,01,2010));
        return newsMap;
    }

}
