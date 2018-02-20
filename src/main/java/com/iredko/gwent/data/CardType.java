package com.iredko.gwent.data;

public enum CardType {

    BRONZE("Bronze"),SILVER("Silver"),GOLD("Gold"),LEADER("Leader");

    public String getDescription() {
        return description;
    }

    private final String description;

    CardType(String desc) {
        this.description = desc;
    }

}
