package com.example.desafioRpe.repositories;

import com.example.desafioRpe.domain.entities.VeiculoDePasseio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VeiculoDePasseioRepository extends JpaRepository<VeiculoDePasseio, UUID> {
    Optional<VeiculoDePasseio> findByPlaca(String placa);
}
