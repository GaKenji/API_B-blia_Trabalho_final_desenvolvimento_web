package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.dto.VersiculoResponseDTO;
import com.example.Gabriel.API_Biblia.entity.Versiculo;
import com.example.Gabriel.API_Biblia.repository.VersiculoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class AleatorioController {
    private final VersiculoRepository repository;

    public AleatorioController(VersiculoRepository repository) {this.repository = repository;}

    @GetMapping("/Aleatório")
    public VersiculoResponseDTO versiculo(){
        List<Versiculo> versiculos = repository.findAll();
        Versiculo versiculo = versiculos.get(new Random().nextInt(versiculos.size()));
        return new VersiculoResponseDTO(
                versiculo.getCapitulo().getLivro().getTitulo(),
                versiculo.getCapitulo().getNumeroCapitulo(),
                versiculo.getNumeroVersiculo(),
                versiculo.getTexto()
        );
    }

}
