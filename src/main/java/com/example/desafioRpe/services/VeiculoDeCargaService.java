package com.example.desafioRpe.services;

import com.example.desafioRpe.domain.dtos.VeiculoDeCargaDto;
import com.example.desafioRpe.domain.entities.VeiculoDeCarga;
import com.example.desafioRpe.domain.exceptions.PlacaJaCadastradaException;
import com.example.desafioRpe.domain.exceptions.VeiculoNaoEncontradoException;
import com.example.desafioRpe.repositories.VeiculoDeCargaRepository;
import com.example.desafioRpe.util.GeradorDePlaca;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeiculoDeCargaService {

    private final VeiculoDeCargaRepository veiculoDeCargaRepository;

    @Autowired
    public VeiculoDeCargaService(VeiculoDeCargaRepository veiculoDeCargaRepository) {
        this.veiculoDeCargaRepository = veiculoDeCargaRepository;
    }

    // Métodos de CRUD

    // Método para salvar um veículo de carga
    public VeiculoDeCarga save(VeiculoDeCargaDto veiculoDeCargaDto) {
        // Verificar se já existe um veículo com a mesma placa
        String placa = veiculoDeCargaDto.placa();
        Optional<VeiculoDeCarga> veiculoExistente = veiculoDeCargaRepository.findByPlaca(placa);

        if (veiculoExistente.isPresent()) {
            throw new PlacaJaCadastradaException("Já existe um veículo com a placa fornecida: " + placa);
        }

        var veiculoDeCarga = new VeiculoDeCarga();
        BeanUtils.copyProperties(veiculoDeCargaDto, veiculoDeCarga);

        if (veiculoDeCarga.getPlaca().isEmpty()) {
            veiculoDeCarga.setPlaca(GeradorDePlaca.gerarPlaca());
        }

        return veiculoDeCargaRepository.save(veiculoDeCarga);
    }

    // Método para listar todos os veículos de carga
    public List<VeiculoDeCarga> findAll() {
        return veiculoDeCargaRepository.findAll();
    }

    // Método para buscar um veículo de carga pelo id
    public VeiculoDeCarga findById(UUID id) {
        Optional<VeiculoDeCarga> veiculoDeCarga = veiculoDeCargaRepository.findById(id);
        return veiculoDeCarga.orElseThrow(VeiculoNaoEncontradoException::new);
    }

    // Método para buscar um veículo de carga pela placa
    public VeiculoDeCarga findByPlaca(String placa) {
        Optional<VeiculoDeCarga> veiculoDeCarga = veiculoDeCargaRepository.findByPlaca(placa);
        return veiculoDeCarga.orElseThrow(VeiculoNaoEncontradoException::new);
    }

    // Método para atualizar um veículo de carga
    public VeiculoDeCarga update(UUID id, VeiculoDeCargaDto veiculoDeCargaDto) {
        VeiculoDeCarga veiculoDeCarga = veiculoDeCargaRepository
                .findById(id)
                .orElseThrow(VeiculoNaoEncontradoException::new);

        BeanUtils.copyProperties(veiculoDeCargaDto, veiculoDeCarga);

        return veiculoDeCargaRepository.save(veiculoDeCarga);
    }

    // Método para deletar um veículo de carga
    public String delete(UUID id) {
        veiculoDeCargaRepository.findById(id).orElseThrow(VeiculoNaoEncontradoException::new);
        veiculoDeCargaRepository.deleteById(id);
        return "Veículo deletado com sucesso!";
    }
}
