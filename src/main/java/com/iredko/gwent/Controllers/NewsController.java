package com.iredko.gwent.Controllers;

import com.iredko.gwent.Models.News;
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
        /*
        TODO так никто не делает. В модель засовываешь список, дальше на jsp перебираешь его елементы
        напр. model.addObject("newsList", getNewsArray());
         */
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
        model.setViewName("newsPage"); //TODO для отображения 1й новости должен быть свой отдельный view
        return model;
    }

    /*
    TODO
    1. public должны быть только методы, которые предназначены для вызова из других классов. Данный метод служебный для текущего. Поэтому такие методы надо делать private.
    2. хранилище новостей должно жить отдельно от контроллера.
    Должна быть абстракция "хранилище новостей" откуда ты будешь доставать список или новость по id,
    а контроллер будет использовать ее как зависимость
    (хранилище передается в контроллер через конструктор, контроллер его сохраняет себе в поле, и потом использует когда надо).
    PS для того чтобы эта абстракция была вставлена спрингом в контроллер его надо либо сконфигурировать отдельно как <bean> в конфиге, либо
    повесить на него аннотацию @Component и положить в место, которое будет найдено твоим <component-scan>
     */
    public ArrayList<News> getNewsArray(){ //TODO не ошибка но совет. обьявленный return-тип должен быть как можно более "общим", в данном случае у тебя просто набор новостей, т.е. ты делаешь Collection<News> (ну или хотя бы List). Вызывающий метод не должен знать что там именно ArrayList
        ArrayList<News> arrayList = new ArrayList<>();
        //TODO никаких адресов ссылок не должно быть в модели. Ссылка должна генерится на view. Передаешь id на view, там пишешь <a href="/news/${currentNews.id}"/>
        News news1 = new News("01.01.2011", "http://localhost:8080/news/0", "Выщел патч.", "Тут должен быть текст статьи 0", "В гвинте вышел новый патч ляляля...");
        News news2 = new News("01.01.2020", "http://localhost:8080/news/1", "Новости от разработчиков", "Тут должен быть текст статьи 1", "Описания статьи про новости от раз...");
        arrayList.add(news1);
        arrayList.add(news2);
        return arrayList;
    }

}
