package com.motomoto.dao.model.listing;

public enum Fuel {
    GASOLINE("Benzyna"),
    DIESEL("Diesel"),
    ELECTRIC("Elektryczny"),
    HYBRID("Hybryda"),
    LPG("Benzyna + LPG");

    private final String friendlyName;

    Fuel(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}