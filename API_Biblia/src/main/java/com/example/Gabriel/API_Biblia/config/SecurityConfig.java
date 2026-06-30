package com.example.Gabriel.API_Biblia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.Gabriel.API_Biblia.repository.UsuarioRepository;
import com.example.Gabriel.API_Biblia.services.JwtService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            JwtService jwtService,
            UsuarioRepository usuarioRepository) throws Exception {
        /*
        Quando eu quiser proteger endpoints com API Key futuramente,
        a estrutura já estará no lugar — é só ajustar o .authorizeHttpRequests.
        */
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login",
                                "/cadastro",

                                "/login.html",
                                "/cadastro.html",
                                "/docs.html",

                                "/css/**",
                                "/js/**",
                                "/img/**",

                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/v3/api-docs"
                        ).permitAll().anyRequest().authenticated()
                )
                .addFilterBefore(
                        jwtAuthenticationFilter(jwtService, usuarioRepository),
                        UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        /*Evita de salvar a senha diretamente no banco
        Com isso, salvamos o hash da senha*/
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            JwtService jwtService,
            UsuarioRepository usuarioRepository){

        return new JwtAuthenticationFilter(jwtService, usuarioRepository);
    }
}
