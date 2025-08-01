package com.motomoto.dao.model.listing.car;

public enum CarBody {
    SEDAN("Sedan"),
    WAGON("Kombi"),
    COUPE("Coupe"),
    CONVERTIBLE("Kabriolet"),
    COMPACT("Kompakt"),
    SUV("SUV"),
    VAN("Minivan");

    private final String friendlyName;

    CarBody(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}