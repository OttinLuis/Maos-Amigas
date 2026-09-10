package com.ottoluis.MaosAmigas.exception;

public class RecursoNaoEncontradoException extends NegocioException {
    public RecursoNaoEncontradoException(String recurso, Long id) {
        super(recurso + " não encontrado com id: " + id);
    }
}