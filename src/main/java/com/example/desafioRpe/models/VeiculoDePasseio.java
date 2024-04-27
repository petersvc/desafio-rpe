package com.example.desafioRpe.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("numeroDePassageiros")
public class VeiculoDePasseio extends Veiculo{
    private int numeroDePassageiros;

    public VeiculoDePasseio(String placa, String nome, String marca, int numeroDePassageiros) {
        super(placa, nome, marca);
        this.numeroDePassageiros = numeroDePassageiros;
    }

    public VeiculoDePasseio() {}

    public int getNumeroDePassageiros() {
        return numeroDePassageiros;
    }

    public void setNumeroDePassageiros(int numeroDePassageiros) {
        this.numeroDePassageiros = numeroDePassageiros;
    }

    @Override
    public String toString() {
        return "VeiculoDePasseio{" +
                ", placa='" + super.getPlaca() + '\'' +
                ", nome='" +super.getNome() + '\'' +
                ", marca=" + super.getMarca() +
                ", numero de passageiros=" + numeroDePassageiros +
                '}';
    }
}
