package com.example.Gabriel.API_Biblia.controller;

import com.example.Gabriel.API_Biblia.dto.DashboardDocsResponseDTO;
import com.example.Gabriel.API_Biblia.entity.Usuario;
import com.example.Gabriel.API_Biblia.services.DashboardDocsService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DashboardDocsController {

    private DashboardDocsService dashboardDocsService;

    public DashboardDocsController(DashboardDocsService dashboardDocsService) {
        this.dashboardDocsService = dashboardDocsService;
    }
    @GetMapping("/dashboard")
    public DashboardDocsResponseDTO dashboard(Authentication authentication) {
        System.out.println(authentication.getPrincipal().getClass());
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return dashboardDocsService.getDashboardDocsResponse(usuario);
    }
}
