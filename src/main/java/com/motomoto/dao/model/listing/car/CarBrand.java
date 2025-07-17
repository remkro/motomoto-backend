package com.motomoto.dao.model.listing.car;

import com.motomoto.dao.model.listing.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Column(length = 36)
    private String id;

    @NotBlank(message = "Brand name is required")
    @Size(max = 50, message = "Brand name must not exceed 50 characters")
    @Column(nullable = false, unique = true)
    private String name;

    @Size(max = 100, message = "Display name must not exceed 100 characters")
    private String displayName;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CarModel> models;
}