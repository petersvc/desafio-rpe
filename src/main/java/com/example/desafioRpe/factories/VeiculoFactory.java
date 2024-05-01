package com.example.desafioRpe.factories;

import com.example.desafioRpe.domain.dtos.VeiculoDeCargaDto;
import com.example.desafioRpe.domain.dtos.VeiculoDePasseioDto;
import com.example.desafioRpe.domain.entities.Veiculo;
import com.example.desafioRpe.domain.entities.VeiculoDeCarga;
import com.example.desafioRpe.domain.entities.VeiculoDePasseio;

public class VeiculoFactory {
    public Veiculo createVeiculo(Object veiculoDto){
        Veiculo veiculo;
        if (veiculoDto instanceof VeiculoDePasseioDto) {
            veiculo = new VeiculoDePasseio();
        } else if (veiculoDto instanceof VeiculoDeCargaDto) {
            veiculo = new VeiculoDeCarga();
        } else {
            throw new IllegalArgumentException("Tipo de veículo desconhecido");
        }
        return veiculo;
    }
}
