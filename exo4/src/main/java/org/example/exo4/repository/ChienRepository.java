package org.example.exo4.repository;

import org.example.exo4.model.Chien;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ChienRepository extends Repository {

    public ChienRepository(Session session) {
        super(session);
    }

    @Override
    public List<Chien> findAll() {
        return _session.createQuery("from Chien").list();
    }

    @Override
    public Chien findById(int id) {
        return _session.get(Chien.class, id);
    }
}
