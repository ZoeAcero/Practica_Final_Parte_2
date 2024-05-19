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

    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula");
        }
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public void setBacterias(List<Bacteria> bacterias) {
        if (bacterias == null) {
            throw new IllegalArgumentException("La lista de bacterias no puede ser nula");
        }
        this.bacterias = bacterias;
    }

}
