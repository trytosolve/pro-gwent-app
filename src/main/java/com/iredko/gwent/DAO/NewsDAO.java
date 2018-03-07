package com.iredko.gwent.DAO;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;


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

    public List<News> selectAllNews() {
        String query = "select * from webapp.news";
        return jdbcTemplate.query(query, new NewsRowMapper());
    }

    public News selectNewsById(int newsId) {
        String query = "select * from webapp.news where id=?";
        return (News) jdbcTemplate.queryForObject(query, new Object[]{newsId}, new NewsRowMapper());
    }

}
