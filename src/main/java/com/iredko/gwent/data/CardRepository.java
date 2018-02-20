package com.iredko.gwent.data;

import com.iredko.gwent.models.SearchForm;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardRepository {
    DbParams dbParams;

    public CardRepository(DbParams dbParams) {
        this.dbParams = dbParams;
    }

    public List<Card> getCardList(SearchFilter searchFilter) {
        List<Card> cardList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find com.mysql.jdbc.Driver", e);
        }
        try (Connection conn = DriverManager.getConnection(dbParams.getUrl(), dbParams.getUsername(), dbParams.getPassword())) {
            String sql = "select name,type,faction,description,url " +
                    "from webapp.cards where (name LIKE ? or type LIKE ? " +
                    "or faction LIKE ? or description LIKE ?)";
            if (searchFilter.getCardTypeSet() != null) {
                if (searchFilter.getCardTypeSet().size() != 0) {
                    sql = sql + " and type in(" + searchFilter.cardTypeToString() + ")";
                }
            }
            if (searchFilter.getCardFactionSet() != null) {
                if (searchFilter.getCardFactionSet().size() != 0) {
                    sql = sql + " and faction in(" + searchFilter.cardFactionToString() + ")";
                }
            }

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + searchFilter.getSearchParam() + "%");
            stmt.setString(2, "%" + searchFilter.getSearchParam() + "%");
            stmt.setString(3, "%" + searchFilter.getSearchParam() + "%");
            stmt.setString(4, "%" + searchFilter.getSearchParam() + "%");

            ResultSet rs = stmt.executeQuery();
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
