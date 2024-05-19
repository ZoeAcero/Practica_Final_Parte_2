package PoblacionDeBacterias;

import Experimento.Bacteria;

import java.util.Date;
import java.util.List;

public class Poblacion {
    private String nombre;
    private Date fechaInicio;
    private List<Bacteria> bacterias;

    public Poblacion(String nombre, Date fechaInicio, List<Bacteria> bacterias) {
        setNombre(nombre);
        setFechaInicio(fechaInicio);
        setBacterias(bacterias);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
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
