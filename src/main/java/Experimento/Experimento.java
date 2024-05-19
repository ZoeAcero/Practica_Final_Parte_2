package Experimento;

import PoblacionDeBacterias.Poblacion;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Experimento {
    private List<Poblacion> poblaciones;
    private int duracion;

    public Experimento(List<Poblacion> poblaciones, int duracion) {
        setPoblaciones(poblaciones);
        setDuracion(duracion);
    }

    public List<Poblacion> getPoblaciones() {
        return this.poblaciones;
    }
}
