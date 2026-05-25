package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.entity.Versiculo;
import com.example.Gabriel.API_Biblia.repository.VersiculoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class UnitarismoController {
    private final VersiculoRepository versiculoRepository;

    public UnitarismoController(VersiculoRepository versiculoRepository) {
        this.versiculoRepository = versiculoRepository;
    }

    @GetMapping("/unitarismo")
    public List<Versiculo> unicismo(){
        return versiculoRepository.findByTemasTema("Unitarismo");
    }
}
