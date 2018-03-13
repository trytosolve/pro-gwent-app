package com.iredko.gwent.DAO;

import com.iredko.gwent.models.News;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class NewsDAO {
    private JdbcTemplate jdbcTemplate;

    //TODO см. коммент ниже
    /*
    НИКОГДА не используй инжекшн через сеттер. Это некорректно. При таком подходе я спокойно могу взять твой код и написать:
    new NewsDAO().insertNews(news);
    этот код будет валидным (скомпилится) но не работающим. При его вызове я получу NullPointerException и должен буду долго дебажить почему именно,
    после чего окажется что я должен был сначала сделать сет поля а потом только использовать класс.
    твой NewsDAO не может работать без темплейта, поэтому темплейт должен требоваться в контрукторе.
    Таким образом ты не разрешаешь создать DAO без темплейта и код становится безопасным.
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO зачем ты тут возвращаешь int? ты его не используешь нигде
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

    //TODO вцелом не ошибка, но у тебя класс и так называется NewsDAO. Из названия понятно что все в нем про новости. Не нужно везде пихать слово News :)
    /*
    ты можешь спокойно называть твои методы
    insert
    selectAll
    selectById
     */
    public News selectNewsById(int newsId) {
        String query = "select * from webapp.news where id=?";
        return (News) jdbcTemplate.queryForObject(query, new Object[]{newsId}, new NewsRowMapper());
    }

}
