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

    @POST
    @Path("/create")
    public Voiture createVoiture(
            @QueryParam("marque")String marque,
            @QueryParam("anneefabrication") int anneefabrication,
            @QueryParam("couleur")String couleur)
    {
        int id = this.voitureService.getVoitures().size() + 1;
        Voiture voiture = null;
        if(this.voitureService.getById(id) != null) {
            voiture = new Voiture(this.voitureService.getVoitures().size() + 2,marque,anneefabrication,couleur);
        }else {
            voiture = new Voiture(this.voitureService.getVoitures().size() + 1,marque,anneefabrication,couleur);
        }
        this.voitureService.add(voiture);
        return voiture;
    }

    @PUT
    @Path("/update")
    public Voiture updateVoiture(@QueryParam("id") int id,
                                 @QueryParam("marque")String marque,
                                 @QueryParam("anneefabrication") String anneefabrication,
                                 @QueryParam("couleur")String couleur
    ){
        Voiture voiture = this.voitureService.getById(id);
        if(voiture == null){
            return null;
        }else{
            if(marque != null){
                voiture.setMarque(marque);
            }
            if(anneefabrication != null){
                voiture.setAnneeFabrication(Integer.parseInt(anneefabrication));
            }
            if(couleur != null){
                voiture.setCouleur(couleur);
            }

            this.voitureService.update(voiture);

            return voiture;
        }

    }

    @DELETE
    @Path("/delete/{id}")
    public Voiture deleteVoiture(@PathParam("id") int id) {
        Voiture voiture = this.voitureService.getById(id);
        this.voitureService.delete(voiture);
        return voiture;
    }

    @GET
    @Path("/{id}")
    public Voiture getById(@PathParam("id") int id) {
        Voiture voiture = this.voitureService.getById(id);
        return voiture;
    }
}
