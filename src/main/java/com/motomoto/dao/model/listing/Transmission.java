package com.motomoto.dao.model.listing;

public enum Transmission {
    MANUAL("Manualna"),
    AUTOMATIC("Automatyczna");

    private final String friendlyName;

    Transmission(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}
