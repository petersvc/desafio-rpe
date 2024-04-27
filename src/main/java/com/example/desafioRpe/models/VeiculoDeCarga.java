package com.example.desafioRpe.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("quantidadeDeCarroceria")
public class VeiculoDeCarga extends Veiculo {
    private int capacidade;
    private int quantidadeDeCarroceria;

    public VeiculoDeCarga(String placa, String nome, String marca, int capacidade, int quantidadeDeCarroceria) {
        super(placa, nome, marca);
        this.capacidade = capacidade;
        this.quantidadeDeCarroceria = quantidadeDeCarroceria;
    }

    public VeiculoDeCarga() {}

    public int getCapacidade() {
        return capacidade;
    }

    public int getQuantidadeDeCarroceria() {
        return quantidadeDeCarroceria;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setQuantidadeDeCarroceria(int quantidadeDeCarroceria) {
        this.quantidadeDeCarroceria = quantidadeDeCarroceria;
    }

    @Override
    public String toString() {
        return "VeiculoDePasseio{" +
                ", placa='" + super.getPlaca() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", marca=" + super.getMarca() + '\'' +
                ", capacidade=" + capacidade + '\'' +
                ", quantidade de carroceria=" + quantidadeDeCarroceria +
                '}';
    }
}
