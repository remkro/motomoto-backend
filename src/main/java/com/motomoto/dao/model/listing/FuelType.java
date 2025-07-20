package com.motomoto.dao.model.listing;

public enum FuelType {
    GASOLINE("Benzyna"),
    DIESEL("Diesel"),
    ELECTRIC("Elektryczny"),
    HYBRID("Hybryda"),
    LPG("Benzyna + LPG");

    private String friendlyName;

    FuelType(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}