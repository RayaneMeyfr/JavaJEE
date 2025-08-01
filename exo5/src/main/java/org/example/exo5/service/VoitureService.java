package org.example.exo5.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exo5.model.Voiture;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VoitureService{
    private List<Voiture> voitures;

    public VoitureService() {
        voitures = new ArrayList<Voiture>();
    }

    public void add(Voiture voiture) {
        this.voitures.add(voiture);
    }

    public void delete(Voiture voiture) {
        this.voitures.remove(voiture);
    }

    public void update(Voiture voiture) {
        for (Voiture voi : voitures) {
            if (voi.getId() == voiture.getId() ){
                voi = voiture;
            }
        }
    }
    public List<Voiture> getVoitures() {
        return voitures;
    }

    public Voiture getById(int id) {
        for (Voiture voi : voitures) {
            if (voi.getId() == id) {
                return voi;
            }
        }
        return null;
    }
}
