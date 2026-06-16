package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.dto.VersiculoResponseDTO;
import com.example.Gabriel.API_Biblia.entity.Versiculo;
import com.example.Gabriel.API_Biblia.repository.VersiculoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnitarismoController {
    private final VersiculoRepository versiculoRepository;

    public UnitarismoController(VersiculoRepository versiculoRepository) {
        this.versiculoRepository = versiculoRepository;
    }

    @GetMapping("/Temas/unitarismo")
    public List<VersiculoResponseDTO> unitarismo(){
        List<Versiculo> versiculos = versiculoRepository.findByTemasTema("Unitarismo");
        return versiculos.stream().map(
                v -> new VersiculoResponseDTO(
                        v.getCapitulo()
                                .getLivro()
                                .getTitulo(),

                        v.getCapitulo()
                                .getNumeroCapitulo(),

                        v.getNumeroVersiculo(),

                        v.getTexto()
                )
        ).toList();
    }
}
