package org.example.exo4.service;

import org.example.exo4.model.Chien;
import org.example.exo4.repository.ChienRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ServiceChien implements IServiceChien {
    private ChienRepository chienRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public ServiceChien(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;
    }

    @Override
    public List<Chien> getAll() {
        List<Chien> cats = new ArrayList<>();
        session = _sessionFactory.openSession();
        chienRepository = new ChienRepository(session);
        try {
            cats = chienRepository.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cats;
    }

    @Override
    public void addChien(Chien chien) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        chienRepository =  new ChienRepository(session);
        try {
            chienRepository.create(chien);
            session.getTransaction().commit();
        }catch(Exception e){
            try {
                session.getTransaction().rollback();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public Chien getChienById(int id) {
        Chien chien = null;
        session = _sessionFactory.openSession();
        try {
            chienRepository = new ChienRepository(session);
            chien = chienRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return chien;
    }

}
