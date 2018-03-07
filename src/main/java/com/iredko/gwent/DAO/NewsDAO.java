package com.iredko.gwent.DAO;

import com.iredko.gwent.models.News;
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
        return jdbcTemplate.query(query, new RowMapper<News>() {
            @Override
            public News mapRow(ResultSet resultSet, int i) throws SQLException {
                News news = new News();
                news.setId(resultSet.getInt(1));
                String title = resultSet.getString(2);
                news.setNewsTitle(new StringBuilder(title.subSequence(0,title.length())));
                String description = resultSet.getString(3);
                news.setNewsDescription(new StringBuilder(description.subSequence(0,description.length())));
                String body = resultSet.getString(4);
                news.setNewsBody(new StringBuilder(body.subSequence(0,body.length())));
                Timestamp timestamp = resultSet.getTimestamp(5);
                news.setCreateDateNews(timestamp.toLocalDateTime());
                return news;
            }
        });
    }

}
