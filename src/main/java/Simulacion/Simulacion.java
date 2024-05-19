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
}
