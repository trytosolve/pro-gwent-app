package com.iredko.gwent.data;

import com.iredko.gwent.models.Card;
import com.iredko.gwent.models.SearchFilter;
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
                    sql = sql + " and (";
                    for (int i=0;i<searchFilter.getCardTypeSet().size();i++) {
                        sql = sql + "type=?";
                        if (i != searchFilter.getCardTypeSet().size()-1) {
                            sql = sql +" or ";
                        }
                    }
                    sql = sql + ")";
                }
            }
            if (searchFilter.getCardFactionSet() != null) {
                if (searchFilter.getCardFactionSet().size() != 0) {
                    sql = sql + " and (";
                    for (int i=0;i<searchFilter.getCardFactionSet().size();i++) {
                        sql = sql + "faction=?";
                        if (i != searchFilter.getCardFactionSet().size()-1) {
                            sql = sql +" or ";
                        }
                    }
                    sql = sql + ")";
                }
            }

            PreparedStatement stmt = conn.prepareStatement(sql);
            int param = 0;
            stmt.setString(++param, "%" + searchFilter.getSearchParam() + "%");
            stmt.setString(++param, "%" + searchFilter.getSearchParam() + "%");
            stmt.setString(++param, "%" + searchFilter.getSearchParam() + "%");
            stmt.setString(++param, "%" + searchFilter.getSearchParam() + "%");
            if (searchFilter.getCardTypeSet() != null) {
                if (searchFilter.getCardTypeSet().size() != 0) {
                    for (CardType cardType : searchFilter.getCardTypeSet()) {
                        stmt.setString(++param,cardType.getDescription());
                    }
                }
            }
            if (searchFilter.getCardFactionSet() != null) {
                if (searchFilter.getCardFactionSet().size() != 0) {
                    for (CardFaction cardFaction : searchFilter.getCardFactionSet()) {
                        stmt.setString(++param,cardFaction.getDescription());
                    }
                }
            }

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
