package com.example.Gabriel.API_Biblia.config;

import com.example.Gabriel.API_Biblia.entity.Usuario;
import com.example.Gabriel.API_Biblia.repository.UsuarioRepository;
import com.example.Gabriel.API_Biblia.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioRepository repository;

    public JwtAuthenticationFilter(JwtService jwtService,  UsuarioRepository repository) {
        this.jwtService = jwtService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        //Leitura do Header
        String header = request.getHeader("Authorization");

        if(header == null || !header.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        if(!jwtService.validarToken(token)){
            filterChain.doFilter(request,response);
            return;
        }

        String email = jwtService.extrairEmail(token);

        Usuario usuario = repository.findByEmail(email)
                .orElse(null);
        System.out.println("Email do token: " + email);

        if(usuario == null){
            filterChain.doFilter(request,response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        null
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Atualiza o número de requisições na página
        String path = request.getRequestURI();

        if (!path.startsWith("/developer")) {
            usuario.setRequisicoes(usuario.getRequisicoes() + 1);
            repository.save(usuario);
        }

        filterChain.doFilter(request, response);
    }
}