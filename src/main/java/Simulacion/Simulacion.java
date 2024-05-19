package Simulacion;

import Experimento.Bacteria;
import Experimento.Plato;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacion {
    private Plato plato;
    private List<Bacteria> bacterias;
    private Random random;

    public Simulacion() {
        this.plato = new Plato(20);
        this.bacterias = new ArrayList<>();
        this.random = new Random();
        inicializarBacterias();
    }

    private void inicializarBacterias() {
        int centro = 20 / 2;
        for (int i = centro - 2; i <= centro + 2; i++) {
            for (int j = centro - 2; j <= centro + 2; j++) {
                bacterias.add(new Bacteria(i, j));
            }
        }
    }

    public void realizarSimulacionDiaria() {
        List<Bacteria> bacteriasParaEliminar = new ArrayList<>();
        List<Bacteria> bacteriasParaAgregar = new ArrayList<>();

        for (Bacteria bacteria : bacterias) {
            for (int i = 0; i < 10; i++) {
                int comida = plato.getCelda(bacteria.getX(), bacteria.getY());

                if (comida >= 100) {
                    bacteria.comer(20);
                    plato.reducirComida(bacteria.getX(), bacteria.getY(), 20);
                } else if (comida > 10) {
                    bacteria.comer(10);
                    plato.reducirComida(bacteria.getX(), bacteria.getY(), 10);
                }

                int accion = random.nextInt(100);

                if (accion < 33) {
                    bacteriasParaEliminar.add(bacteria);
                } else if (accion >= 66) {
                    bacteria.mover();
                }

                int hijas = bacteria.reproducir();
                for (int j = 0; j < hijas; j++) {
                    bacteriasParaAgregar.add(new Bacteria(bacteria.getX(), bacteria.getY()));
                }
            }
        }

        bacterias.removeAll(bacteriasParaEliminar);
        bacterias.addAll(bacteriasParaAgregar);
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public int calcularTotalBacterias() {
        return bacterias.size();
    }

    public Bacteria encontrarBacteriaConMasComida() {
        Bacteria maxBacteria = null;
        int maxComida = 0;
        for (Bacteria bacteria : bacterias) {
            int comida = bacteria.getComidaConsumida();
            if (comida > maxComida) {
                maxComida = comida;
                maxBacteria = bacteria;
            }
        }
        return maxBacteria;
    }

    public void realizarSimulacion(int dias) {
        for (int i = 0; i < dias; i++) {
            realizarSimulacionDiaria();
        }
    }
}
