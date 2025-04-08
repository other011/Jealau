package com.Jealau.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class WeddingVenue extends PanacheEntity {

    @NotBlank(message = "Venue name cannot be blank")
    @Column(nullable = false, length = 100)
    public String name;

    @Column(length = 255)
    public String address;

    @Min(value = 1, message = "Capacity must be at least 1")
    public int capacity;

    @Column(length = 100)
    public String contactPerson;

    @Column(length = 20)
    public String phoneNumber;

    @Column(length = 100)
    public String email;

    @Column(columnDefinition = "TEXT")
    public String description;

    // Default constructor needed by JPA
    public WeddingVenue() {}
}