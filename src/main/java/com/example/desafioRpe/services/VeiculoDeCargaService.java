package com.example.desafioRpe.services;

import com.example.desafioRpe.dtos.VeiculoDeCargaRecordDto;
import com.example.desafioRpe.models.VeiculoDeCarga;
import com.example.desafioRpe.repositories.VeiculoDeCargaRepository;
import com.example.desafioRpe.util.GeradorDePlaca;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VeiculoDeCargaService {

    private final VeiculoDeCargaRepository VeiculoDeCargaRepository;

    @Autowired
    public VeiculoDeCargaService(VeiculoDeCargaRepository veiculoDeCargaRepository) {
        this.VeiculoDeCargaRepository = veiculoDeCargaRepository;
    }

    // Métodos de CRUD

    // Método para listar todos os veículos de passeio
    public List<VeiculoDeCarga> findAll() {
        return VeiculoDeCargaRepository.findAll();
    }

    // Método para buscar um veículo de passeio pelo id
    public VeiculoDeCarga findById(UUID id) {
        return VeiculoDeCargaRepository.findById(id).orElse(null);
    }

    // Método para buscar um veículo de passeio pela placa
    public VeiculoDeCarga findByPlaca(String placa) {
        return VeiculoDeCargaRepository.findByPlaca(placa);
    }

    // Método para salvar um veículo de passeio
    public VeiculoDeCarga save(VeiculoDeCargaRecordDto veiculoDeCargaRecordDto) {
        var veiculoDeCarga = new VeiculoDeCarga();

        BeanUtils.copyProperties(veiculoDeCargaRecordDto, veiculoDeCarga);

        if (veiculoDeCarga.getPlaca().isEmpty()) {
            veiculoDeCarga.setPlaca(GeradorDePlaca.gerarPlaca());
        }

        return VeiculoDeCargaRepository.save(veiculoDeCarga);
    }

    // Método para atualizar um veículo de passeio
    public VeiculoDeCarga update(VeiculoDeCarga veiculoDeCarga) {
        return VeiculoDeCargaRepository.save(veiculoDeCarga);
    }

    // Método para deletar um veículo de passeio
    public String delete(UUID id) {
        try {
            VeiculoDeCargaRepository.deleteById(id);
            return "Veículo apagado com sucesso";
        } catch (Exception e) {
            return "Falha ao excluir veículo: " + e.getMessage();
        }
    }
}
