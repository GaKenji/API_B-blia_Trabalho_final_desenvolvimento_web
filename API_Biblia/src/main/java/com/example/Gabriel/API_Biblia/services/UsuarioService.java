package com.example.Gabriel.API_Biblia.services;

import com.example.Gabriel.API_Biblia.dto.CadastroUsuarioDTO;
import com.example.Gabriel.API_Biblia.entity.Usuario;
import com.example.Gabriel.API_Biblia.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UsuarioService(UsuarioRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Usuario cadastrar(CadastroUsuarioDTO dto){
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(encoder.encode(dto.getSenha()));
        usuario.setApi_key(UUID.randomUUID().toString());
        usuario.setData_criacao(LocalDateTime.now());
        usuario.setRequisicoes(0L);

        if(repository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("E-mail já cadastrado");
        }
        return repository.save(usuario);
    }
}
