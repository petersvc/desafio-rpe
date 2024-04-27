package com.example.desafioRpe.util;

public class GeradorPlaca {
    public static String gerarPlaca() {
        StringBuilder placa = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            placa.append((char) (Math.random() * 26 + 65));
        }

        placa.append("-");

        for (int i = 0; i < 4; i++) {
            placa.append((int) (Math.random() * 10));
        }

        return placa.toString();
    }
}
