package com.example.Gabriel.API_Biblia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DashboardDocsResponseDTO {
    private String nome;
    private String apiKey;
    private Long requisicoes;
}
