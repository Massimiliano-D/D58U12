package org.example;

import entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;

    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("PARTECIPAZIONE SALVATA!!");

    }

    public Partecipazione findPartecipazioneId(long id) {
        return em.find(Partecipazione.class, id);

    }

    public void deletePartecipazioneId(long id) {
        Partecipazione found = em.find(Partecipazione.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("PARTECIPAZIONE ELIMINATA!!");
        } else {
            System.out.println("PARTECIPAZIONE NON TROVATA!!");
        }
    }
}
