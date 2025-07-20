package com.motomoto.dao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Auditable {
    @Column(name = "created_by")
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    protected LocalDateTime createdOn;

    @Column(name = "last_modified_by")
    protected String lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_on")
    protected LocalDateTime lastModifiedOn;

    @PrePersist
    private void beforeSave() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        this.lastModifiedOn = LocalDateTime.now();
    }
}