package com.example.Gabriel.API_Biblia.repository;

import com.example.Gabriel.API_Biblia.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
