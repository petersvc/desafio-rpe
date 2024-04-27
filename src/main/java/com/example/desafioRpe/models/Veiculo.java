package com.example.desafioRpe.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veiculo", discriminatorType = DiscriminatorType.STRING)
public abstract class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String placa;
    private String nome;
    private String marca;

    public Veiculo() {}

    public Veiculo(String placa, String nome, String marca) {
        this.placa = placa;
        this.nome = nome;
        this.marca = marca;
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
