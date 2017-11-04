package com.iredko.gwent.Controllers;

import com.iredko.gwent.Models.News;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/news")
public class NewsController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMain(ModelAndView model) throws IOException {
        News news = getNewsArray().get(0);
        model.addObject("date", news.getPostDate());
        model.addObject("discription", news.getDiscription());
        model.addObject("name", news.getName());
        model.addObject("path", news.getPath());
        News news1 = getNewsArray().get(1);
        model.addObject("date1", news1.getPostDate());
        model.addObject("discription1", news1.getDiscription());
        model.addObject("name1", news1.getName());
        model.addObject("path1", news1.getPath());
        model.setViewName("newsPage");
        return model;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView getNews(@PathVariable int id, ModelAndView model) {
        News news = getNewsArray().get(id);
        model.addObject("text", news.getText());
        model.setViewName("newsPage");
        return model;
    }

    public ArrayList<News> getNewsArray(){
        ArrayList<News> arrayList = new ArrayList<>();
        News news1 = new News("01.01.2011", "http://localhost:8080/news/0", "Выщел патч.", "Тут должен быть текст статьи 0", "В гвинте вышел новый патч ляляля...");
        News news2 = new News("01.01.2020", "http://localhost:8080/news/1", "Новости от разработчиков", "Тут должен быть текст статьи 1", "Описания статьи про новости от раз...");
        arrayList.add(news1);
        arrayList.add(news2);
        return arrayList;
    }

}
