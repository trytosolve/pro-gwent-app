package com.iredko.gwent.models;

public class News {
    private static int count;
    private final int id = count++;
    private final String postDate;
    private String name;
    private String text;
    private String description;


    public News(String postDate, String name, String text, String discription) {
        this.postDate = postDate;
        this.name = name;
        this.text = text;
        this.description = discription;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
