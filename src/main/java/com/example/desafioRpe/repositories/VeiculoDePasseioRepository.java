package com.example.desafioRpe.repositories;

import com.example.desafioRpe.models.VeiculoDePasseio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeiculoDePasseioRepository extends JpaRepository<VeiculoDePasseio, UUID> {
    VeiculoDePasseio findByPlaca(String placa);
}
