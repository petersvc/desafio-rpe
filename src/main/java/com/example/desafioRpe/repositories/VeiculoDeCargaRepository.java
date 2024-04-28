package com.example.desafioRpe.repositories;

import com.example.desafioRpe.models.VeiculoDeCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeiculoDeCargaRepository extends JpaRepository<VeiculoDeCarga, UUID> {
    VeiculoDeCarga findByPlaca(String placa);
}
