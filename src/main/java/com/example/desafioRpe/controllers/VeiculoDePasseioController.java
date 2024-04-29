package com.example.desafioRpe.controllers;

import com.example.desafioRpe.dtos.VeiculoDePasseioRecordDto;
import com.example.desafioRpe.models.VeiculoDePasseio;
import com.example.desafioRpe.services.VeiculoDePasseioService;
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
@RequestMapping("/api/veiculos-de-passeio")
@Tag(name = "Veículo de passeio", description = "API para gerenciamento de veículos de passeio")
public class VeiculoDePasseioController {

    private final VeiculoDePasseioService veiculoDePasseioService;

    @Autowired
    public VeiculoDePasseioController(VeiculoDePasseioService veiculoDePasseioService) {
        this.veiculoDePasseioService = veiculoDePasseioService;
    }

    @PostMapping
    public ResponseEntity<VeiculoDePasseio> save(@RequestBody @Valid VeiculoDePasseioRecordDto veiculoDePasseioRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoDePasseioService.save(veiculoDePasseioRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDePasseio>> getAllVeiculosDePasseio() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") UUID id) {
        Optional<VeiculoDePasseio> veiculoDePasseio = Optional.ofNullable(veiculoDePasseioService.findById(id));
        if (veiculoDePasseio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseio.get());
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Object> findByPlaca(@PathVariable(value="placa") String placa) {
        Optional<VeiculoDePasseio> veiculoDePasseio = Optional.ofNullable(veiculoDePasseioService.findByPlaca(placa));
        if (veiculoDePasseio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseio.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody VeiculoDePasseio veiculoDePasseio) {
        Optional<VeiculoDePasseio> veiculoDePasseioOptional = Optional.ofNullable(veiculoDePasseioService.findById(id));
        if (veiculoDePasseioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseioService.update(veiculoDePasseio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<VeiculoDePasseio> veiculoDePasseio = Optional.ofNullable(veiculoDePasseioService.findById(id));
        if (veiculoDePasseio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDePasseioService.delete(id));
    }
}
