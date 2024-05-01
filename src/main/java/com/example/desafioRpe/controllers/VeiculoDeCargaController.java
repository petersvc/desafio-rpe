package com.example.desafioRpe.controllers;

import com.example.desafioRpe.domain.dtos.VeiculoDeCargaDto;
import com.example.desafioRpe.domain.entities.VeiculoDeCarga;
import com.example.desafioRpe.services.VeiculoDeCargaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/veiculos-de-carga")
@Tag(name = "Veículo de carga", description = "API para gerenciamento de veículos de carga")
public class VeiculoDeCargaController implements SecuredRestController {

    private final VeiculoDeCargaService veiculoDeCargaService;

    @Autowired
    public VeiculoDeCargaController(VeiculoDeCargaService veiculoDeCargaService) {
        this.veiculoDeCargaService = veiculoDeCargaService;
    }

    @PostMapping
    public ResponseEntity<VeiculoDeCarga> save(@RequestBody @Valid VeiculoDeCargaDto veiculoDeCargaDto) {
        var veiculoDeCarga = veiculoDeCargaService.save(veiculoDeCargaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoDeCarga);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDeCarga>> getAllVeiculosDePasseio() {
        var veiculosDePasseio = veiculoDeCargaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(veiculosDePasseio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") UUID id) {
        var veiculoDeCarga = veiculoDeCargaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCarga);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Object> findByPlaca(@PathVariable(value="placa") String placa) {
        var veiculoDeCarga = veiculoDeCargaService.findByPlaca(placa);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCarga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody @Valid VeiculoDeCargaDto veiculoDeCargaDto) {
        var veiculoDeCarga = veiculoDeCargaService.update(id, veiculoDeCargaDto);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCarga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        var response = veiculoDeCargaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
