package com.motomoto.dao.model.listing.car;

import com.motomoto.dao.model.Auditable;
import com.motomoto.dao.model.listing.Fuel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "car_models")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel extends Auditable {
    @Id
    @UuidGenerator
    private String id;

    private String name;

    @Column(name = "display_name")
    private String displayName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private CarBrand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "default_fuel")
    private Fuel defaultFuel;

    @Enumerated(EnumType.STRING)
    @Column(name = "default_body")
    private CarBody defaultBody;
}