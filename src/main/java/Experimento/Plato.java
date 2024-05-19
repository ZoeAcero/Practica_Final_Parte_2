package Experimento;

import java.util.Random;

public class Plato {
    private static final int COMIDA_INICIAL = 20000;

    private int[][] celdas;
    private Random random;

    public Plato(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("El tamaño del plato debe ser positivo");
        }
        this.celdas = new int[size][size];
        this.random = new Random();
        inicializar();
    }

    public int getCelda(int x, int y) {
        validarCoordenadas(x, y);
        return celdas[x][y];
    }

    public void reducirComida(int x, int y, int cantidad) {
        validarCoordenadas(x, y);
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de comida a reducir debe ser positiva");
        }
        celdas[x][y] -= cantidad;
    }

    private void inicializar() {
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] = COMIDA_INICIAL;
            }
        }
    }

    public void distribuirComidaConstante(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de comida a distribuir debe ser positiva");
        }
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] += cantidad;
            }
        }
    }
}
