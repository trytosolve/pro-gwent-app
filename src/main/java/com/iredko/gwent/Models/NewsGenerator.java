package com.iredko.gwent.Models;

import java.io.IOException;

public class NewsGenerator {
    public static void main(String[] args) throws IOException {
        NewsMap newsMap = new NewsMap();
        newsMap.addNews(new News("D:/1.txt",01,01,2010));
        newsMap.addNews(new News("D:/2.txt",02,01,2010));
        System.out.println(newsMap.getNews(1).getText());
    }
}
