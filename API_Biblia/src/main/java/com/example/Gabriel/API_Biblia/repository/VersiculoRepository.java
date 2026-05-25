package com.example.Gabriel.API_Biblia.repository;

import com.example.Gabriel.API_Biblia.entity.Versiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersiculoRepository extends JpaRepository<Versiculo, Long> {
    List<Versiculo> findByTemasTema(String tema);
}
