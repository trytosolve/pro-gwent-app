package com.iredko.gwent.data;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsRowMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        News news = new News();
        news.setId(rs.getInt(1));
        news.setNewsTitle(rs.getString(2));
        news.setNewsDescription(rs.getString(3));
        news.setNewsBody(rs.getString(4));
        news.setCreateDateNews(rs.getTimestamp(5).toLocalDateTime());
        return news;
    }
}
