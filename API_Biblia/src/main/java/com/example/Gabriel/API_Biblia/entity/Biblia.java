package com.example.Gabriel.API_Biblia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "biblias")
public class Biblia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "versao", nullable = false)
    private String nomeVersao;
}
