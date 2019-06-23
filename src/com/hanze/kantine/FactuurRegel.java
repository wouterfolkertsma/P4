package com.hanze.kantine;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factuur_regel")
public class FactuurRegel implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private Long id;

    @OneToOne
    private Factuur factuur;

    /* Embedded want dat zorgt ervoor dat een "snapshot" van een product wordt gemaakt
        van het artikel.
    */
    @Embedded
    private Artikel artikel;

    public FactuurRegel() {

    }
    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    @Override
    public String toString() {
        return "FactuurRegel{" +
                "id=" + id +
                ", factuur=" + factuur +
                ", artikel=" + artikel +
                '}';
    }
}
