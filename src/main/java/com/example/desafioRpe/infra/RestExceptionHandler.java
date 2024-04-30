package com.example.desafioRpe.infra;

import com.example.desafioRpe.domain.exceptions.PlacaJaCadastradaException;
import com.example.desafioRpe.domain.exceptions.VeiculoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    // Exception handling methods
    @ExceptionHandler(VeiculoNaoEncontradoException.class)
    public ResponseEntity<String> veiculoNotFoundHandler(VeiculoNaoEncontradoException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(PlacaJaCadastradaException.class)
    public ResponseEntity<String> placaJaCadastradaHandler(PlacaJaCadastradaException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
