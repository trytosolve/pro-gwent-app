package com.iredko.gwent.models;

import java.time.LocalDateTime;

public class News {
    private LocalDateTime createDateNews;
    private StringBuilder newsTitle;
    private StringBuilder newsDescription;
    private StringBuilder newsBody;

//    public News(LocalDateTime createDateNews, StringBuilder newsTitle, StringBuilder newsDescription, StringBuilder newsBody) {
////        this.createDateNews = LocalDateTime.now();
//        this.newsTitle = newsTitle;
//        this.newsDescription = newsDescription;
//        this.newsBody = newsBody;
//    }


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