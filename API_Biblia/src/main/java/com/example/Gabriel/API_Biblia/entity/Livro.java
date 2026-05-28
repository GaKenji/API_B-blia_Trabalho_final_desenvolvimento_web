package com.example.Gabriel.API_Biblia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Nome",  nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_biblia")
    private Biblia biblia;
}
