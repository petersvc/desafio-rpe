package com.example.desafioRpe.domain.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veiculo", discriminatorType = DiscriminatorType.STRING)
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    @Column(unique = true)
    private String placa;
    private String nome;
    private String marca;

    public Veiculo() {}

    public Veiculo(String placa, String nome, String marca) {
        this.placa = placa;
        this.nome = nome;
        this.marca = marca;
    }

    public UUID getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getNome() {
        return nome;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
