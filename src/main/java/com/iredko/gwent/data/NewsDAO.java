package com.iredko.gwent.data;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class NewsDAO {

    private JdbcTemplate jdbcTemplate;

    public NewsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(News news) {
        String title = news.getNewsTitle();
        String description = news.getNewsDescription();
        String body = news.getNewsBody();
        String create_time = news.getCreateDateNews().toString();
        String query = "insert into webapp.news (title,description,body,create_time) values(?,?,?,?)";
        jdbcTemplate.update(query,title,description,body,create_time);
    }

    public List<News> selectAll() {
        String query = "select * from webapp.news order by id desc";
        return jdbcTemplate.query(query, new NewsRowMapper());
    }

    public News selectById(int newsId) {
        String query = "select * from webapp.news where id=?";
        return jdbcTemplate.queryForObject(query, new Object[]{newsId}, new NewsRowMapper());
    }

}
