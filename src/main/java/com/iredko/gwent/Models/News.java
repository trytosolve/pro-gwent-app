package com.iredko.gwent.Models;

import java.io.*;
import java.nio.channels.Channel;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class News {
    private static int count;
    private final int id = ++count;
    private String postDate;
    private String path;
    private String name;
    private String text;
    private String discription;


    public News(String postDate, String path, String name, String text, String discription) {
        this.postDate = postDate;
        this.path = path;
        this.name = name;
        this.text = text;
        this.discription = discription;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getDiscription() {
        return discription;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
