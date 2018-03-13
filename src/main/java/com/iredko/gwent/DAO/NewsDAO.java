package com.iredko.gwent.DAO;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class NewsDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertNews(News news) {
        StringBuilder title = news.getNewsTitle();
        StringBuilder description = news.getNewsDescription();
        StringBuilder body = news.getNewsBody();
        String create_time = news.getCreateDateNews().toString();
        String query = "insert into webapp.news (title,description,body,create_time) values(?,?,?,?)";
        return jdbcTemplate.update(query,title,description,body,create_time);
    }

    public List<News> selectAllNews() {
        String query = "select * from webapp.news order by id desc";
        return jdbcTemplate.query(query, new NewsRowMapper());
    }

    public News selectNewsById(int newsId) {
        String query = "select * from webapp.news where id=?";
        return (News) jdbcTemplate.queryForObject(query, new Object[]{newsId}, new NewsRowMapper());
    }

}
