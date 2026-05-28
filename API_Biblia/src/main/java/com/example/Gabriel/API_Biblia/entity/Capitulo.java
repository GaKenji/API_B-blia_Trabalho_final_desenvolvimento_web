package com.example.Gabriel.API_Biblia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "capitulos")

public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capitulo", nullable = false)
    private Integer numeroCapitulo;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;
}
