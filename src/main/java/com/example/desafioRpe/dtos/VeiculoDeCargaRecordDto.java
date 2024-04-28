package com.example.desafioRpe.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDeCargaRecordDto(String placa, @NotBlank String nome, @NotBlank String marca, @NotNull double capacidade, @NotNull int quantidadeDeCarroceria) {
}
