package org.example.exo4.service;

import org.example.exo4.model.Chien;

import java.util.List;

public interface IServiceChien {

    List<Chien> getAll();

    void addChien(Chien chien);

    Chien getChienById(int id);
}
