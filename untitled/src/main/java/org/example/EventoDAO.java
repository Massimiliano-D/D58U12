package org.example;

import entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(evento);


        transaction.commit();
        System.out.println("Nuovo evento salvato correttamente");
    }

    public Evento findById(long id) {
        
        return em.find(Evento.class, id);
    }

    public void findByIdAndDelete(long id) {


        Evento found = em.find(Evento.class, id);

        if (found != null) {


            EntityTransaction transaction = em.getTransaction();


            transaction.begin();


            em.remove(found);


            transaction.commit();
            System.out.println("L'evento' è stato cancellato correttamente");
        } else {

            System.err.println("L'evento' con l'id " + id + " non è stato trovato");
        }

    }
}
