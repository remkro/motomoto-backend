package com.motomoto.dao.model.listing.car;

import com.motomoto.dao.model.listing.Listing;
import jakarta.persistence.*;

@Entity
@Table(name = "car_listing")
@DiscriminatorValue("CAR")
public class CarListing extends Listing {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private CarBrand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private CarModel model;
}
