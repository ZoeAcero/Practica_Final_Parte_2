package Experimento;

import java.util.Random;

public class Bacteria {

    private static final int UMBRAL_ALTO = 150000;
    private static final int UMBRAL_MEDIO = 100000;
    private static final int UMBRAL_BAJO = 50000;

    private int x;
    private int y;
    private int comidaConsumida;
    private Random random;

    public Bacteria(int x, int y) {
        this.x = x;
        this.y = y;
        this.comidaConsumida = 0;
        this.random = new Random();
    }
}
