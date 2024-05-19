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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void mover() {
        x += random.nextInt(3) - 1; // Mover la bacteria a una celda contigua en el eje x
        y += random.nextInt(3) - 1; // Mover la bacteria a una celda contigua en el eje y
    }

    public void comer(int comida) {
        if (comida < 0) {
            throw new IllegalArgumentException("La comida no puede ser negativa");
        }
        if (comida >= 100) {
            this.comidaConsumida += 20;
        } else if (comida > 10) {
            this.comidaConsumida += 10;
        }
    }
}
