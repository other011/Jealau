package com.Jealau.repository;

import com.Jealau.entity.WeddingVenue;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WeddingVenueRepository implements PanacheRepository<WeddingVenue> {
}