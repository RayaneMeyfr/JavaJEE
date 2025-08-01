package org.example.exo6hopitale.model;

import java.time.LocalDate;
import java.util.List;

public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String photo;
    private List<Consultation> consultations;

    public Personne() {}
}
