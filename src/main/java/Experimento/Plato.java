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
}
