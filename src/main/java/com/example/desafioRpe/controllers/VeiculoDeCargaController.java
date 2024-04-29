package com.example.desafioRpe.controllers;

import com.example.desafioRpe.dtos.VeiculoDeCargaRecordDto;
import com.example.desafioRpe.models.VeiculoDeCarga;
import com.example.desafioRpe.services.VeiculoDeCargaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/veiculos-de-carga")
@Tag(name = "Veículo de carga", description = "API para gerenciamento de veículos de carga")
public class VeiculoDeCargaController {

    private final VeiculoDeCargaService veiculoDeCargaService;

    @Autowired
    public VeiculoDeCargaController(VeiculoDeCargaService veiculoDeCargaService) {
        this.veiculoDeCargaService = veiculoDeCargaService;
    }

    @PostMapping
    public ResponseEntity<VeiculoDeCarga> save(@RequestBody @Valid VeiculoDeCargaRecordDto veiculoDeCargaRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoDeCargaService.save(veiculoDeCargaRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDeCarga>> getAllVeiculosDePasseio() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCargaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") UUID id) {
        Optional<VeiculoDeCarga> veiculoDeCarga = Optional.ofNullable(veiculoDeCargaService.findById(id));
        if (veiculoDeCarga.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCarga.get());
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Object> findByPlaca(@PathVariable(value="placa") String placa) {
        Optional<VeiculoDeCarga> veiculoDeCarga = Optional.ofNullable(veiculoDeCargaService.findByPlaca(placa));
        if (veiculoDeCarga.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCarga.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody VeiculoDeCarga veiculoDeCarga) {
        Optional<VeiculoDeCarga> veiculoDeCargaOptional = Optional.ofNullable(veiculoDeCargaService.findById(id));
        if (veiculoDeCargaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCargaService.update(veiculoDeCarga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<VeiculoDeCarga> veiculoDeCarga = Optional.ofNullable(veiculoDeCargaService.findById(id));
        if (veiculoDeCarga.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDeCargaService.delete(id));
    }
}
