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

    public void distribuirComidaIncrementoLineal(int cantidadInicial, int cantidadFinal, int dia, int duracion) {
        if (cantidadInicial < 0 || cantidadFinal < 0 || dia < 0 || duracion <= 0) {
            throw new IllegalArgumentException("Las cantidades de comida, el día y la duración deben ser positivos");
        }
        int cantidad = cantidadInicial + (cantidadFinal - cantidadInicial) * dia / duracion;
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] += cantidad;
            }
        }
    }

    public void distribuirComidaAlternado(int cantidad, int dia) {
        if (cantidad < 0 || dia < 0) {
            throw new IllegalArgumentException("La cantidad de comida y el día deben ser positivos");
        }
        if (dia % 2 == 0) {
            for (int i = 0; i < celdas.length; i++) {
                for (int j = 0; j < celdas[i].length; j++) {
                    celdas[i][j] += cantidad;
                }
            }
        }
    }

    public int calcularTotalComida() {
        int total = 0;
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                total += celdas[i][j];
            }
        }
        return total;
    }

    public int[] encontrarCeldaConMasComida() {
        int maxComida = 0;
        int[] coordenadas = new int[2];
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                if (celdas[i][j] > maxComida) {
                    maxComida = celdas[i][j];
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }

    public void distribuirComidaAleatoria(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de comida a distribuir debe ser positiva");
        }
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                if (random.nextBoolean()) {
                    celdas[i][j] += cantidad;
                }
            }
        }
    }

    private void validarCoordenadas(int x, int y) {
        if (x < 0 || x >= celdas.length || y < 0 || y >= celdas[0].length) {
            throw new IllegalArgumentException("Las coordenadas están fuera del rango del plato");
        }
    }
}
