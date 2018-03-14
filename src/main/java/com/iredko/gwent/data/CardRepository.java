package com.iredko.gwent.data;

import com.iredko.gwent.models.Card;
import com.iredko.gwent.models.SearchFilter;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardRepository {

    private DbParams dbParams;

    public CardRepository(DbParams dbParams) {
        this.dbParams = dbParams;
    }

    public List<Card> getCardList(SearchFilter searchFilter) {
        loadDriver();
        try (Connection conn = DriverManager.getConnection(dbParams.getUrl(), dbParams.getUsername(), dbParams.getPassword())) {

            List<ColumnFilter> cardFiltersList = new ArrayList();
            if (!searchFilter.getSearchParam().equals("")) {
                StringFilter cardNameFilter = new StringFilter("name", searchFilter.getSearchParam());
                cardFiltersList.add(cardNameFilter);
            }
            if (!searchFilter.getSearchParam().equals("")) {
                StringFilter descriptionFilter = new StringFilter("description", searchFilter.getSearchParam());
                cardFiltersList.add(descriptionFilter);
            }
            if (searchFilter.getCardTypeSet() != null) {
                if (searchFilter.getCardTypeSet().size()!=0) {
                    OptionFilter<CardType> cardTypeFilter =
                            new OptionFilter<CardType>("type", new ArrayList<>(searchFilter.getCardTypeSet()));
                    cardFiltersList.add(cardTypeFilter);
                }
            }
            if (searchFilter.getCardFactionSet() != null) {
                if (searchFilter.getCardFactionSet().size()!=0) {
                    OptionFilter<CardFaction> cardFactionFilter =
                            new OptionFilter<CardFaction>("faction", new ArrayList<>(searchFilter.getCardFactionSet()));
                    cardFiltersList.add(cardFactionFilter);
                }
            }
            ResultSet rs = new CardsStatementGenerator().generate(conn, cardFiltersList).executeQuery();
            return parseResults(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find com.mysql.jdbc.Driver", e);
        }
    }

    private List<Card> parseResults(ResultSet rs) throws SQLException {
        List<Card> list = new ArrayList<>();
        while (rs.next()) {
            list.add(parsCard(rs));
        }
        return list;
    }

    private Card parsCard(ResultSet rs) throws SQLException {
        Card card = new Card();
        card.setName(rs.getString("name"));
        card.setType(rs.getString("type"));
        card.setFaction(rs.getString("faction"));
        card.setDescription(rs.getString("description"));
        card.setUrl(rs.getString("url"));
        return card;
    }

}
