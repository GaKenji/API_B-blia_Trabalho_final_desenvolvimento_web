package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.entity.Versiculo;
import com.example.Gabriel.API_Biblia.repository.AllVersiculos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class AleatorioController {

    @GetMapping("/versiculo/aleatorio")
    public Versiculo versiculo(){
        AllVersiculos allVersiculo = new AllVersiculos();
        List<Versiculo> versiculos = allVersiculo.getVersiculos();

        Random rand = new Random();
        int index = rand.nextInt(versiculos.size());
        return versiculos.get(index);
    }

}
