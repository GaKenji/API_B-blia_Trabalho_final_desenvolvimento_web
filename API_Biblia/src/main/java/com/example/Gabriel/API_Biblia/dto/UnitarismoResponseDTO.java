package com.example.Gabriel.API_Biblia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Organiza a resposta do endpoint "unitarismo"
public class UnitarismoResponseDTO {
    private String livro;
    private int capitulo;
    private int numVersiculo;
    private String versiculo;
}
