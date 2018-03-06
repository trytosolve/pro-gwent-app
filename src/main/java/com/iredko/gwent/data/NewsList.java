package com.iredko.gwent.data;

import com.iredko.gwent.models.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/*
Контейнер новостей
 */
@Component
public class NewsList {

    List<News> newsList;

    public void addNews(News news) {
        newsList.add(news);
    }

    public News getNews(int id) {
        return newsList.get(id);
    }

    public List<News> getAll() {
        return newsList;
    }

    public NewsList() {
        newsList = new ArrayList<>();
//        News news1 = new News("01.01.2011",  "Выщел патч.", "Тут должен быть текст статьи 0", "В гвинте вышел новый патч ляляля...");
//        News news2 = new News("01.01.2020",  "Новости от разработчиков", "Тут должен быть текст статьи 1", "Описания статьи про новости от раз...");
//        News news3 = new News("20.20.2020",  "Всем новостям новости", "Тут должен быть текст статьи 2", "Ох уж эти новости...");
//        newsList.add(news1);
//        newsList.add(news2);
//        newsList.add(news3);
    }
}

