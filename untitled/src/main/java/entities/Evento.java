package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
    private LocalDate data_evento;
    private String descrizione;
    @Enumerated(EnumType.STRING)// Annotazione specifica per gli Enum
    private TipoEvento tipo_evento;
    private int numero_max_partc;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
    private Set<Partecipazione> setPartecipanti;
    @ManyToOne
    private Location location;

    public Evento() {

    }

    public Evento(String titolo, LocalDate data_evento, String descrizione, TipoEvento tipo_evento, int numero_max_partc) {

        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.tipo_evento = tipo_evento;
        this.numero_max_partc = numero_max_partc;
    }

    public Set<Partecipazione> getSetPartecipanti() {
        return setPartecipanti;
    }

    public void setSetPartecipanti(Set<Partecipazione> setPartecipanti) {
        this.setPartecipanti = setPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(TipoEvento tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public int getNumero_max_partc() {
        return numero_max_partc;
    }

    public void setNumero_max_partc(int numero_max_partc) {
        this.numero_max_partc = numero_max_partc;
    }

}
