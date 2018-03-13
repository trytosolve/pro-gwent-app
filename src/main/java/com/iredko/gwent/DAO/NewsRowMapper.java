package com.iredko.gwent.DAO;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

//TODO если ты откроешь класс RowMapper, то увидишь что он все таки RowMapper<T>
//TODO и если бы ты обьявил свой класс как implements RowMapper<News> то метод mapRow возвращал бы не Object а News
//TODO плюс в NewsDAO#selectNewsById не надо было бы ничего кастить
public class NewsRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        News news = new News();
        news.setId(resultSet.getInt(1));
        String title = resultSet.getString(2);
        //TODO а если бы в News были строки не надо было бы заниматься хуйней типа создания стрингбилдера из строки :)
        news.setNewsTitle(new StringBuilder(title.subSequence(0,title.length())));
        String description = resultSet.getString(3);
        news.setNewsDescription(new StringBuilder(description.subSequence(0,description.length())));
        String body = resultSet.getString(4);
        news.setNewsBody(new StringBuilder(body.subSequence(0,body.length())));
        Timestamp timestamp = resultSet.getTimestamp(5);
        news.setCreateDateNews(timestamp.toLocalDateTime());
        return news;
    }
}
