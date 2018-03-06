package com.iredko.gwent.DAO;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.JdbcTemplate;

public class NewsDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertNews(News news) {
        String query = "insert into webapp.news (title,description,body,create_time) values("+news.getNewsTitle()+"," +
                ""+news.getNewsDescription()+","+news.getNewsBody()+","+news.getCreateDateNews()+")";
        return jdbcTemplate.update(query);
    }


}
