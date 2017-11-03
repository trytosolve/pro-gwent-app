package com.iredko.gwent.Models;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NewsMap {
    private Map newsMap = new HashMap();

    public void addNews(News news){
        newsMap.put(news.getId(), news);
    }

    public News getNews(int id) {
        News news = (News)newsMap.get(id);
        return news;

    }
}
