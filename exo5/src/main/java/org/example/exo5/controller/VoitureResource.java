package org.example.exo5.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exo5.model.Voiture;
import org.example.exo5.service.VoitureService;

import java.time.LocalDate;
import java.util.List;

@Path("/voiture")
@Produces(MediaType.APPLICATION_JSON)
public class VoitureResource {

    private VoitureService voitureService;

    @Inject
    public VoitureResource(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GET
    public Voiture oneVoiture() {
        return new Voiture(1,"test",2000,"test");
    }

    @GET
    @Path("/all")
    public List<Voiture> allVoiture() {
        return this.voitureService.getVoitures();
    }

    @GET
    @Path("/create")
    public Voiture createVoiture(
            @QueryParam("marque")String marque,
            @QueryParam("anneefabrication") int anneefabrication,
            @QueryParam("couleur")String couleur)
    {
        voitureService.add(new Voiture(voitureService.getVoitures().size() + 1,marque,anneefabrication,couleur));
        return voitureService.getById(voitureService.getVoitures().size());
    }
}
