package com.iredko.gwent.Models;

import java.io.*;
import java.nio.channels.Channel;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class News {
    private static int count;
    private final int id = ++count;
    private Date postDate;
    private String path;
    private StringBuffer text;

    public News(String path, int day, int month, int year) throws IOException {
        String string;
        text = new StringBuffer();
        postDate = new Date(year, month, day);
        FileReader fileReader = new FileReader(new File(path));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((string = bufferedReader.readLine()) != null) {
            text.append(string + "\n") ;
        }
    }

    public static int getCount() {
        return count;
    }

    public Date getPostDate() {
        return postDate;
    }

    public String getPath() {
        return path;
    }

    public StringBuffer getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
