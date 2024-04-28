package com.example.desafioRpe.services;

import com.example.desafioRpe.dtos.VeiculoDePasseioRecordDto;
import com.example.desafioRpe.models.VeiculoDePasseio;
import com.example.desafioRpe.repositories.VeiculoDePasseioRepository;
import com.example.desafioRpe.util.GeradorDePlaca;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VeiculoDePasseioService {

    private final VeiculoDePasseioRepository veiculoDePasseioRepository;

    @Autowired
    public VeiculoDePasseioService(VeiculoDePasseioRepository veiculoDePasseioRepository) {
        this.veiculoDePasseioRepository = veiculoDePasseioRepository;
    }
    
    // Métodos de CRUD
    
    // Método para listar todos os veículos de passeio
    public List<VeiculoDePasseio> findAll() {
        return veiculoDePasseioRepository.findAll();
    }

    // Método para buscar um veículo de passeio pela placa
    public VeiculoDePasseio findById(UUID id) {
        return veiculoDePasseioRepository.findById(id).orElse(null);
    }

    public VeiculoDePasseio findByPlaca(String placa) {
        return veiculoDePasseioRepository.findByPlaca(placa);
    }

    // Método para salvar um veículo de passeio
    public VeiculoDePasseio save(VeiculoDePasseioRecordDto veiculoDePasseioRecordDto) {
        var veiculoDePasseio = new VeiculoDePasseio();

        BeanUtils.copyProperties(veiculoDePasseioRecordDto, veiculoDePasseio);

        if (veiculoDePasseio.getPlaca().isEmpty()) {
            veiculoDePasseio.setPlaca(GeradorDePlaca.gerarPlaca());
        }

        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }

    // Método para atualizar um veículo de passeio
    public VeiculoDePasseio update(VeiculoDePasseio veiculoDePasseio) {
        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }

    // Método para deletar um veículo de passeio
    public String delete(UUID id) {
        try {
            veiculoDePasseioRepository.deleteById(id);
            return "Veículo apagado com sucesso";
        } catch (Exception e) {
            return "Falha ao excluir veículo: " + e.getMessage();
        }
    }
}
