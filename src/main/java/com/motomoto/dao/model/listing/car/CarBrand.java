package com.motomoto.dao.model.listing.car;

import com.motomoto.dao.model.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "car_brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrand extends Auditable {
    @Id
    @UuidGenerator
    private String id;

    private String name;

    @Column(name = "display_name")
    private String displayName;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CarModel> models;
}