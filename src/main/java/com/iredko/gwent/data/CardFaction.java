package com.iredko.gwent.data;

public enum CardFaction {

    NEUTRAL("Neutral"), NORTHEN_REALMS("Northen_Realms"),SCOIATAEL("Scoiatael"), MONSTERS("Monsters"),
    SKELIGE("Skelige"), NILFGAARD("Nilfgaard");

    final String description;

    CardFaction(String desc) {
        this.description = desc;
    }
}
