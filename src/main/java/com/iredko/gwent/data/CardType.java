package com.iredko.gwent.data;

public enum CardType {

    BRONZE("Bronze"),SILVER("Silver"),GOLD("Gold"),LEADER("Leader");

    final String description;

    CardType(String desc) {
        this.description = desc;
    }

}
