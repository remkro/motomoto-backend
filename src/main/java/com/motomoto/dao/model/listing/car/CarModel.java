package com.motomoto.dao.model.listing.car;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "car_models")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {
    @Id
    @UuidGenerator
    @Column(length = 36)
    private String id;

    @NotBlank(message = "Model name is required")
    @Size(max = 50, message = "Model name must not exceed 50 characters")
    @Column(nullable = false)
    private String name;

    @Size(max = 100, message = "Display name must not exceed 100 characters")
    private String displayName;

    @NotNull(message = "Start year is required")
    @Min(value = 1900, message = "Start year must be after 1900")
    private Integer startYear;

    @Min(value = 1900, message = "End year must be after 1900")
    private Integer endYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    @NotNull(message = "Brand is required")
    private CarBrand brand;
}