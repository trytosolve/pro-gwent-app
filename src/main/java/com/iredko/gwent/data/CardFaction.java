package com.iredko.gwent.data;

public enum CardFaction {

    NEUTRAL("Neutral"), NORTHEN_REALMS("Northen Realms"),SCOIATAEL("Scoia'tael"), MONSTERS("Monsters"),
    SKELLIGE("Skellige"), NILFGAARD("Nilfgaard");

    public String getDescription() {
        return description;
    }

    private final String description;

    CardFaction(String desc) {
        this.description = desc;
    }

    @Override
    public String toString() {
        return description;
    }
}
