package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Persona {
    @Id
    @GeneratedValue
    Long id;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String email;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
    private List<Partecipazione> listaPatecipanti;
}
