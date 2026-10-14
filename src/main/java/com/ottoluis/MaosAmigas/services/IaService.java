package com.ottoluis.MaosAmigas.services;

import com.ottoluis.MaosAmigas.ia.GroqClient;
import org.springframework.stereotype.Service;

@Service
public class IaService {

    private final GroqClient groqClient;

    public IaService(GroqClient groqClient) {
        this.groqClient = groqClient;
    }

    public String conversar(String mensagem) {

        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException(
                    "A mensagem não pode estar vazia."
            );
        }

        return groqClient.conversar(mensagem);
    }
}