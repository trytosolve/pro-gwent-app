package com.iredko.gwent.models;

import com.iredko.gwent.data.CardFaction;
import com.iredko.gwent.data.CardType;

import javax.validation.constraints.Size;
import java.util.Set;

public class SearchForm {

    @Size(min = 0,max = 20)
    String searchParam;

    Set<CardType> typesList;

    Set<CardFaction> factionsList;


    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public Set<CardType> getTypesList() {
        return typesList;
    }

    public void setTypesList(Set<CardType> typesList) {
        this.typesList = typesList;
    }

    public Set<CardFaction> getFactionsList() {
        return factionsList;
    }

    public void setFactionsList(Set<CardFaction> factionsList) {
        this.factionsList = factionsList;
    }
}
