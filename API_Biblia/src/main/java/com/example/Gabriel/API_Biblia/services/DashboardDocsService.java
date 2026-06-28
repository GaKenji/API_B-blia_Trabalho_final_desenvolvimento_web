package com.example.Gabriel.API_Biblia.services;

import com.example.Gabriel.API_Biblia.dto.DashboardDocsResponseDTO;
import com.example.Gabriel.API_Biblia.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class DashboardDocsService {

    public DashboardDocsResponseDTO getDashboardDocsResponse(Usuario usuario) {
        return new DashboardDocsResponseDTO(
                usuario.getNome(),
                usuario.getApikey(),
                usuario.getRequisicoes()
        );
    }

}
