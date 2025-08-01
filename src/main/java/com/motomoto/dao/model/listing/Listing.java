package com.motomoto.dao.model.listing;

import com.motomoto.dao.model.Auditable;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "listing")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "listing_type")
public abstract class Listing extends Auditable {
    @Id
    @UuidGenerator
    private String id;

    private String title;

    private Integer year;

    private BigDecimal price;

    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    private Boolean featured = false;
}
