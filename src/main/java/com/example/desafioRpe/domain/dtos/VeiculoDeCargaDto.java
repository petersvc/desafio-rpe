package com.example.desafioRpe.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDeCargaDto(String placa, @NotBlank String nome, @NotBlank String marca, @NotNull double capacidade, @NotNull int quantidadeDeCarroceria) {
}
