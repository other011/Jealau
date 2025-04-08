package com.Jealau.resource;

import com.Jealau.entity.WeddingVenue;
import com.Jealau.repository.WeddingVenueRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/wedding-venues")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WeddingVenueResource {

    @Inject
    WeddingVenueRepository repository;

    @GET
    public List<WeddingVenue> listAll() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public WeddingVenue get(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @POST
    @Transactional
    public Response create(WeddingVenue venue) {
        repository.persist(venue);
        return Response.status(Response.Status.CREATED).entity(venue).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, WeddingVenue venue) {
        WeddingVenue entity = repository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.name = venue.name;
        entity.address = venue.address;
        entity.capacity = venue.capacity;
        entity.contactPerson = venue.contactPerson;
        entity.phoneNumber = venue.phoneNumber;
        entity.email = venue.email;
        entity.description = venue.description;
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        WeddingVenue entity = repository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        repository.delete(entity);
        return Response.noContent().build();
    }
}