package com.example.Gabriel.API_Biblia.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "versiculos")
public class Versiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "versiculo", nullable = false)
    private Integer numeroVersiculo;

    @Column(name = "texto", nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "id_capitulo")
    private Capitulo capitulo;

    @ManyToMany
    @JoinTable(
            name = "versiculo_tema",
            joinColumns = @JoinColumn(name = "versiculo_id"),
            inverseJoinColumns = @JoinColumn(name = "tema_id")
    )
    private List<Tema> temas;
}
