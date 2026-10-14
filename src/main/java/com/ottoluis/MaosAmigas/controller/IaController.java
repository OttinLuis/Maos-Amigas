 package com.ottoluis.MaosAmigas.controller;

import com.ottoluis.MaosAmigas.dto.IaChatRequest;
import com.ottoluis.MaosAmigas.dto.IaChatResponse;
import com.ottoluis.MaosAmigas.services.IaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ia")
public class IaController {

    private final IaService iaService;

    public IaController(IaService iaService) {
        this.iaService = iaService;
    }

    @GetMapping
    public ResponseEntity<IaChatResponse> conversarGet(
            @RequestParam String mensagem
    ) {

        String resposta = iaService.conversar(mensagem);

        return ResponseEntity.ok(
                new IaChatResponse(resposta)
        );
    }

    @PostMapping("/chat")
    public ResponseEntity<IaChatResponse> conversar(
            @RequestBody IaChatRequest request
    ) {

        String resposta = iaService.conversar(
                request.mensagem()
        );

        return ResponseEntity.ok(
                new IaChatResponse(resposta)
        );
    }
}
