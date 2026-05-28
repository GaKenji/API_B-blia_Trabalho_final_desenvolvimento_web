package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.dto.UnitarismoResponseDTO;
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

    @GetMapping("/unitarismo")
    public List<UnitarismoResponseDTO> unitarismo(){
        List<Versiculo> versiculos = versiculoRepository.findByTemasTema("Unitarismo");
        return versiculos.stream().map(
                v -> new UnitarismoResponseDTO(
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
