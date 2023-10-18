package org.example;

import entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;

    }

    public void save(Persona person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("PARTECIPANTE SALVATO!!");

    }

    public Persona findPersonaId(long id) {
        return em.find(Persona.class, id);

    }

    public void deletePersonaId(long id) {
        Persona found = em.find(Persona.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("PARTECIPANTE ELIMINATO!!");
        } else {
            System.out.println("PARTECIPANTE NON TROVATO!!");
        }
    }
}
