package com.example.Gabriel.API_Biblia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
