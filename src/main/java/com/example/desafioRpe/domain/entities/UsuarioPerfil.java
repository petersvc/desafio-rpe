package com.example.desafioRpe.domain.entities;

public enum UsuarioPerfil {
    ADMIN("admin"),
    USUARIO("usuario");

    private final String perfil;

    UsuarioPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

}
