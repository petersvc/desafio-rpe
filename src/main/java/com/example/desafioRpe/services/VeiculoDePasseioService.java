package com.example.desafioRpe.services;

import com.example.desafioRpe.domain.dtos.VeiculoDePasseioDto;
import com.example.desafioRpe.domain.entities.VeiculoDePasseio;
import com.example.desafioRpe.domain.exceptions.PlacaJaCadastradaException;
import com.example.desafioRpe.domain.exceptions.VeiculoNaoEncontradoException;
import com.example.desafioRpe.repositories.VeiculoDePasseioRepository;
import com.example.desafioRpe.util.GeradorDePlaca;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeiculoDePasseioService {

    private final VeiculoDePasseioRepository veiculoDePasseioRepository;

    @Autowired
    public VeiculoDePasseioService(VeiculoDePasseioRepository veiculoDePasseioRepository) {
        this.veiculoDePasseioRepository = veiculoDePasseioRepository;
    }
    
    // Métodos de CRUD

    // Método para salvar um veículo de passeio
    public VeiculoDePasseio save(VeiculoDePasseioDto veiculoDePasseioDto) {
        // Verificar se já existe um veículo com a mesma placa
        String placa = veiculoDePasseioDto.placa();
        Optional<VeiculoDePasseio> veiculoExistente = veiculoDePasseioRepository.findByPlaca(placa);

        if (veiculoExistente.isPresent()) {
            throw new PlacaJaCadastradaException("Já existe um veículo com a placa fornecida: " + placa);
        }

        var veiculoDePasseio = new VeiculoDePasseio();
        BeanUtils.copyProperties(veiculoDePasseioDto, veiculoDePasseio);

        if (veiculoDePasseio.getPlaca().isEmpty()) {
            veiculoDePasseio.setPlaca(GeradorDePlaca.gerarPlaca());
        }

        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }
    
    // Método para listar todos os veículos de passeio
    public List<VeiculoDePasseio> findAll() {
        return veiculoDePasseioRepository.findAll();
    }

    // Método para buscar um veículo de passeio pela placa
    public VeiculoDePasseio findById(UUID id) {
        Optional<VeiculoDePasseio> veiculoDePasseio = veiculoDePasseioRepository.findById(id);
        return veiculoDePasseio.orElseThrow(VeiculoNaoEncontradoException::new);
    }

    public VeiculoDePasseio findByPlaca(String placa) {
        Optional<VeiculoDePasseio> veiculoDePasseio = veiculoDePasseioRepository.findByPlaca(placa);
        return veiculoDePasseio.orElseThrow(VeiculoNaoEncontradoException::new);
    }

    // Método para atualizar um veículo de passeio
    public VeiculoDePasseio update(UUID id, VeiculoDePasseioDto veiculoDePasseioDto) {
        VeiculoDePasseio veiculoDePasseio = veiculoDePasseioRepository
                .findById(id)
                .orElseThrow(VeiculoNaoEncontradoException::new);

        BeanUtils.copyProperties(veiculoDePasseioDto, veiculoDePasseio);

        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }

    // Método para deletar um veículo de passeio
    public String delete(UUID id) {
        veiculoDePasseioRepository.findById(id).orElseThrow(VeiculoNaoEncontradoException::new);
        veiculoDePasseioRepository.deleteById(id);
        return "Veículo deletado com sucesso!";
    }
}
