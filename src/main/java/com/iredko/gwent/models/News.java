package com.iredko.gwent.models;

import java.time.LocalDateTime;

public class News {
    private int id;
    private StringBuilder newsTitle;
    private StringBuilder newsDescription;
    private StringBuilder newsBody;
    private LocalDateTime createDateNews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateNews() {
        return createDateNews;
    }

    public void setCreateDateNews(LocalDateTime createDateNews) {
        this.createDateNews = createDateNews;
    }

    public StringBuilder getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(StringBuilder newsTitle) {
        this.newsTitle = newsTitle;
    }

    public StringBuilder getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(StringBuilder newsDescription) {
        this.newsDescription = newsDescription;
    }

    public StringBuilder getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(StringBuilder newsBody) {
        this.newsBody = newsBody;
    }
}