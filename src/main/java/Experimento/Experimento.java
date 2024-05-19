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

    public void setPoblaciones(List<Poblacion> poblaciones) {
        if (poblaciones == null) {
            throw new IllegalArgumentException("La lista de poblaciones no puede ser nula");
        }
        this.poblaciones = poblaciones;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa");
        }
        this.duracion = duracion;
    }

    // Método adicional para agregar una nueva población
    public void agregarNuevaPoblacion(Poblacion nuevaPoblacion) {
        Objects.requireNonNull(nuevaPoblacion, "La nueva población no puede ser nula");
        this.poblaciones.add(nuevaPoblacion);
    }

    public void ordenarPoblacionesPorFecha() {
        poblaciones.sort(Comparator.comparing(Poblacion::getFechaInicio));
    }

    public void ordenarPoblacionesPorNombre() {
        poblaciones.sort(Comparator.comparing(Poblacion::getNombre));
    }

    public void ordenarPoblacionesPorNumeroBacterias() {
        poblaciones.sort(Comparator.comparing(p -> p.getBacterias().size()));
    }
}
