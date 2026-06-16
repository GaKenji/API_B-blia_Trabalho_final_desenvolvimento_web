package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.dto.TemaResponseDTO;
import com.example.Gabriel.API_Biblia.entity.Tema;
import com.example.Gabriel.API_Biblia.repository.TemaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemasController {
    private final TemaRepository temaRepository;

    public TemasController(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    @GetMapping("/Temas")
    public List<TemaResponseDTO> temas(){
        List<Tema> temas = temaRepository.findAll();
        return temas.stream().map(t -> new TemaResponseDTO(
                    t.getTema()
                )
        ).toList();
    }
}
