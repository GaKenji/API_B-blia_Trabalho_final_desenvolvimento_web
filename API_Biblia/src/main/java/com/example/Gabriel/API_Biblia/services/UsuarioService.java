package com.example.Gabriel.API_Biblia.services;

import com.example.Gabriel.API_Biblia.dto.CadastroUsuarioDTO;
import com.example.Gabriel.API_Biblia.services.JwtService;
import com.example.Gabriel.API_Biblia.dto.LoginResponseDTO;
import com.example.Gabriel.API_Biblia.dto.LoginDTO;
import com.example.Gabriel.API_Biblia.entity.Usuario;
import com.example.Gabriel.API_Biblia.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;//Para o acesso aos CRUDs
    private final BCryptPasswordEncoder encoder;//
    private final JwtService jwtService;

    public UsuarioService(UsuarioRepository repository, BCryptPasswordEncoder encoder, JwtService jwtService) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService =  jwtService;
    }

    public Usuario cadastrar(CadastroUsuarioDTO dto){
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(encoder.encode(dto.getSenha()));
        usuario.setApikey(UUID.randomUUID().toString());
        usuario.setData_criacao(LocalDateTime.now());
        usuario.setRequisicoes(0L);

        if(repository.findByEmail(dto.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado");
        }
        return repository.save(usuario);
    }

    public LoginResponseDTO login(LoginDTO dto){
        Usuario usuario = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        if(!encoder.matches(dto.getSenha(), usuario.getSenha()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Senha Inválida");

        String token = jwtService.gerarToken(usuario);

        return new LoginResponseDTO(token);
    }
}
