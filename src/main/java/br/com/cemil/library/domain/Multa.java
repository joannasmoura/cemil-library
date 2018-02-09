package br.com.cemil.library.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="multa")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "pessoa_multa",
            joinColumns = { @JoinColumn(name = "multa_id") },
            inverseJoinColumns = { @JoinColumn(name = "pessoa_id") }
    )
    private List<Pessoa> pessoas;

    @Column(name = "valorMulta")
    private Double valorMulta;

}
