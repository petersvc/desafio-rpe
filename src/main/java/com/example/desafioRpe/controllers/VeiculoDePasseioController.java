package com.example.desafioRpe.controllers;

import com.example.desafioRpe.domain.dtos.VeiculoDePasseioDto;
import com.example.desafioRpe.domain.entities.VeiculoDePasseio;
import com.example.desafioRpe.services.VeiculoDePasseioService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/veiculos-de-passeio")
@Tag(name = "Veículo de passeio", description = "API para gerenciamento de veículos de passeio")
public class VeiculoDePasseioController {

    private final VeiculoDePasseioService veiculoDePasseioService;

    @Autowired
    public VeiculoDePasseioController(VeiculoDePasseioService veiculoDePasseioService) {
        this.veiculoDePasseioService = veiculoDePasseioService;
    }

    @PostMapping
    public ResponseEntity<VeiculoDePasseio> save(@RequestBody @Valid VeiculoDePasseioDto veiculoDePasseioDto) {
        var veiculoDePasseio = veiculoDePasseioService.save(veiculoDePasseioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoDePasseio);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDePasseio>> getAllVeiculosDePasseio() {
        var veiculosDePasseio = veiculoDePasseioService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(veiculosDePasseio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") UUID id) {
        var veiculoDePasseio = veiculoDePasseioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseio);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Object> findByPlaca(@PathVariable(value="placa") String placa) {
        var veiculoDePasseio = veiculoDePasseioService.findByPlaca(placa);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody @Valid VeiculoDePasseioDto veiculoDePasseioDto) {
        var veiculoDePasseio = veiculoDePasseioService.update(id, veiculoDePasseioDto);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
       var response = veiculoDePasseioService.delete(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
