package com.iredko.gwent.models;

import java.time.LocalDateTime;

public class News {
    private int id;
    private String newsTitle;
    private String newsDescription;
    private String newsBody;
    private LocalDateTime createDateNews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public LocalDateTime getCreateDateNews() {
        return createDateNews;
    }

    public void setCreateDateNews(LocalDateTime createDateNews) {
        this.createDateNews = createDateNews;
    }
}