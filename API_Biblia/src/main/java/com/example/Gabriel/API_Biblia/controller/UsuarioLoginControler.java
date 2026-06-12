package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.dto.LoginDTO;
import com.example.Gabriel.API_Biblia.entity.Usuario;
import com.example.Gabriel.API_Biblia.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioLoginControler {
    private final UsuarioService service;

    public UsuarioLoginControler(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario login(@RequestBody LoginDTO dto){return service.login(dto);}
}
