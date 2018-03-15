package com.iredko.gwent.models;

import com.iredko.gwent.data.CardFaction;
import com.iredko.gwent.data.CardType;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class SearchForm {

    @Size(max = 20)
    private String searchParam;

    private Set<CardType> typesSet;

    private Set<CardFaction> factionsSet;

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public Set<CardType> getTypesSet() {
        return typesSet;
    }

    public void setTypesSet(Set<CardType> typesSet) {
        this.typesSet = typesSet;
    }

    public Set<CardFaction> getFactionsSet() {
        return factionsSet;
    }

    public void setFactionsSet(Set<CardFaction> factionsSet) {
        this.factionsSet = factionsSet;
    }
}
