package com.example.desafioRpe.services;

import com.example.desafioRpe.domain.dtos.VeiculoDePasseioDto;
import com.example.desafioRpe.domain.exceptions.PlacaJaCadastradaException;
import com.example.desafioRpe.domain.exceptions.VeiculoNaoEncontradoException;
import com.example.desafioRpe.repositories.VeiculoDePasseioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class VeiculoDePasseioServiceTest {

    @Mock
    private VeiculoDePasseioRepository veiculoDePasseioRepository;

    @Autowired
    private VeiculoDePasseioService veiculoDePasseioService;

    @Test
    public void findByIdVeiculoNaoEncontradoDeveLancarExcecao() {
        // Cenário
        UUID idInvalido = UUID.randomUUID();
        // Verificação
        assertThrows(VeiculoNaoEncontradoException.class, () -> {
            veiculoDePasseioService.findById(idInvalido);
        });
    }

    @Test
    public void saveDeveLancarExcecaoQuandoPlacaJaCadastrada() {
        String placa = "ABC-1234";
        var veiculoDePasseioDto = new VeiculoDePasseioDto(placa, "uno", "fiat", 4);

        veiculoDePasseioService.save(veiculoDePasseioDto); // Salva o primeiro veículo

        var veiculoDePasseioDto2 = new VeiculoDePasseioDto(placa, "palio", "fiat", 5);

        assertThrows(PlacaJaCadastradaException.class, () -> veiculoDePasseioService.save(veiculoDePasseioDto2));
    }
}
