package com.example.desafioRpe.domain.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException() {
        super("Veículo não encontrado");
    }

    public VeiculoNaoEncontradoException(String message) {
        super(message);
    }
}
