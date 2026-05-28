package com.example.Gabriel.API_Biblia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "temas")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tema;

    @ManyToMany(mappedBy = "temas")
    private List<Versiculo> versiculos;
}
