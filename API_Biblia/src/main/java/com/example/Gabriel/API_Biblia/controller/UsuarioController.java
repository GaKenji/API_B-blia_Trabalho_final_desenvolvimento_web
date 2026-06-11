package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.dto.CadastroUsuarioDTO;
import com.example.Gabriel.API_Biblia.entity.Usuario;
import com.example.Gabriel.API_Biblia.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody CadastroUsuarioDTO dto){
        return service.cadastrar(dto);
    }
}
