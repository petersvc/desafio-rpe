package com.example.desafioRpe.domain.exceptions;

public class PlacaJaCadastradaException extends RuntimeException{
    public PlacaJaCadastradaException() {
        super("Placa já cadastrada");
    }

    public PlacaJaCadastradaException(String message) {
        super(message);
    }
}
