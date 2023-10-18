package entities;


import javax.persistence.*;

@Entity
@Table(name = "partecipanti")
public class Partecipazione {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Persona persona;
    @ManyToOne
    Evento evento;
    Stato stato;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
