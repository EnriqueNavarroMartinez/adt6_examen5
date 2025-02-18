package org.simarro.adt6_examen5.model;

import java.time.LocalDate;

public class ReservaRequestDTO {

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int precioTotal;
    private String emailCliente;

    public ReservaRequestDTO(LocalDate fechaEntrada, LocalDate fechaSalida, int precioTotal, String emailCliente) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;
        this.emailCliente = emailCliente;
    }

    public ReservaRequestDTO() {
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
