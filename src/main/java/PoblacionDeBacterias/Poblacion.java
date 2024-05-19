package PoblacionDeBacterias;

import Experimento.Bacteria;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Poblacion {
    private String nombre;
    private LocalDate fechaInicio;
    private List<Bacteria> bacterias;

    public Poblacion(String nombre, LocalDate fechaInicio, List<Bacteria> bacterias) {
        setNombre(nombre);
        setFechaInicio(fechaInicio);
        setBacterias(bacterias);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

}