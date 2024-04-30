package com.example.desafioRpe.domain.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("carga")
public class VeiculoDeCarga extends Veiculo {
    // Capacitade em toneladas
    private double capacidade;
    private int quantidadeDeCarroceria;

    public VeiculoDeCarga(String placa, String nome, String marca, double capacidade, int quantidadeDeCarroceria) {
        super(placa, nome, marca);
        this.capacidade = capacidade;
        this.quantidadeDeCarroceria = quantidadeDeCarroceria;
    }

    public VeiculoDeCarga() {}

    public double getCapacidade() {
        return capacidade;
    }

    public int getQuantidadeDeCarroceria() {
        return quantidadeDeCarroceria;
    }

    public void setCapacidade(double capacidade) {
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
