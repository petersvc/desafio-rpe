package com.example.desafioRpe.domain.dtos;

import com.example.desafioRpe.domain.entities.UsuarioPerfil;

public record RegistroDto(String login, String senha, UsuarioPerfil perfil) {
}
