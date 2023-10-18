package org.example;

import entities.Evento;
import entities.TipoEvento;

import javax.persistence.EntityManager;

import java.time.LocalDate;

import static org.example.JpaUtil.getEntityManagerFactory;

public class Main {
    //private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {

        // Evento even1 = new Evento("Peppino di Capri", LocalDate.of(2022, 10, 26), "Nostalgia BOOMER", TipoEvento.PUBBLICO, 200000);
        //  Evento even2 = new Evento("Matrimonio", LocalDate.of(2021, 8, 15), "Roviniamo Estati", TipoEvento.PRIVATO, 200);
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {

            EventoDAO ev = new EventoDAO(em);
            System.out.println("Hello World!");

            // 1. Salvataggio nuovo evento
            Evento peppino = new Evento("Peppino di Capri", LocalDate.of(2022, 10, 26), "Nostalgia BOOMER", TipoEvento.PUBBLICO, 200000);
            ev.save(peppino);


            /*// 1.A Salvataggio nuovo evento
            Evento matrimonio = new Evento("Matrimonio", LocalDate.of(2021, 8, 15), "Roviniamo Estati", TipoEvento.PRIVATO, 200);
            ev.save(matrimonio);
            //ev.findByIdAndDelete(1);
            ev.findByIdAndDelete(2);*/


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {

            em.close();

        }

    }
}
