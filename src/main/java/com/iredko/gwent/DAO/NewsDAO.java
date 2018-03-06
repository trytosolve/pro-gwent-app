package com.iredko.gwent.DAO;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewsDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertNews(News news) {
        String query = "insert into webapp.news (title,description,body,create_time) values('"+news.getNewsTitle()+"','" +
                ""+news.getNewsDescription()+"','"+news.getNewsBody()+"','"+news.getCreateDateNews()+"')";
        return jdbcTemplate.update(query);
    }

//    public List<News> selectAllNews() {
//        List<News> newsList = new ArrayList<>();
//        String query  = "select * from webapp.news";
//        List<Map> rows = getJdbcTemplate().get
//        return null;
//    }

}
