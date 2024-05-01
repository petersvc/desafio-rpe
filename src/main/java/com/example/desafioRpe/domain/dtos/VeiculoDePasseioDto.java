package com.example.desafioRpe.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDePasseioDto(String placa, @NotBlank String nome, @NotBlank String marca, @NotNull int numeroDePassageiros){
}
