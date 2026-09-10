package com.ottoluis.MaosAmigas.exception;

public abstract class NegocioException extends RuntimeException {
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
