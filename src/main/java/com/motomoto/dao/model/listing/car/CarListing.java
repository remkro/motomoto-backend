package com.motomoto.dao.model.listing.car;

import com.motomoto.dao.model.listing.Listing;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "car_listing")
public class CarListing extends Listing {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    @NotNull(message = "Brand is required")
    private CarBrand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    @NotNull(message = "Model is required")
    private CarModel model;
}
