package com.iredko.gwent.data;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardRepository {
    DbParams dbParams;

    public CardRepository(DbParams dbParams) {
        this.dbParams = dbParams;
    }

    public List<Card> getCardList(){
        List<Card> cardList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find com.mysql.jdbc.Driver",e);
        }
        try(Connection conn= DriverManager.getConnection(dbParams.getUrl(),dbParams.getUsername(),dbParams.getPassword())) {
            String sql = "select name,type,faction,description,url " +
                    "from webapp.cards";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Card card = new Card();
                card.setName(rs.getString("name"));
                card.setType(rs.getString("type"));
                card.setFaction(rs.getString("faction"));
                card.setDescription(rs.getString("description"));
                card.setUrl(rs.getString("url"));
                cardList.add(card);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get cards from database", e);
        }
        return cardList;
    }
}
