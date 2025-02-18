package org.simarro.adt6_examen5.model;

import java.time.LocalDate;

public class ReservaResponseDTO {

        private String nombreCliente;
        private LocalDate fechaEntrada;
        private int precioTotal;

    public ReservaResponseDTO(String nombreCliente, LocalDate fechaEntrada, int precioTotal) {
        this.nombreCliente = nombreCliente;
        this.fechaEntrada = fechaEntrada;
        this.precioTotal = precioTotal;
    }

    public ReservaResponseDTO() {
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
}

