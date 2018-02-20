package com.iredko.gwent.data;

import org.springframework.stereotype.Component;

import javax.smartcardio.Card;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SearchFilter {

    String searchParam;

    Set<CardType> cardTypeSet;

    Set<CardFaction> cardFactionSet;

    public SearchFilter() {
        this.searchParam = "";
        this.cardTypeSet = null;
        this.cardFactionSet = null;
    }

    public SearchFilter(String searchParam, Set<CardType> cardTypeSet, Set<CardFaction> cardFactionSet) {
        this.searchParam = searchParam;
        this.cardTypeSet = cardTypeSet;
        this.cardFactionSet = cardFactionSet;
    }

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public Set<CardType> getCardTypeSet() {
        return cardTypeSet;
    }

    public void setCardTypeSet(Set<CardType> cardTypeSet) {
        this.cardTypeSet = cardTypeSet;
    }

    public Set<CardFaction> getCardFactionSet() {
        return cardFactionSet;
    }

    public void setCardFactionSet(Set<CardFaction> cardFactionSet) {
        this.cardFactionSet = cardFactionSet;
    }

    public StringBuilder cardTypeToString() {
        StringBuilder result = new StringBuilder();
        for (CardType type : cardTypeSet) {
            if (result.length() != 0) {
                result.append(",");
            }
            result.append("\'");
            result.append(type.getDescription());
            result.append("\'");
        }
        return result;
    }

    public StringBuilder cardFactionToString() {
        StringBuilder result = new StringBuilder();
        for (CardFaction faction : cardFactionSet) {
            if (result.length() != 0) {
                result.append(",");
            }
            result.append("\'");
            result.append(faction.getDescription());
            result.append("\'");
        }
        return result;
    }
}
