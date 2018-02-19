package com.iredko.gwent.data;

import org.springframework.stereotype.Component;

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
}
