package org.simarro.adt6_examen5.model;

public class ResumenDTO {

    private int confirmadas;
    private int noConfirmadas;

    public ResumenDTO(int confirmadas, int noConfirmadas) {
        this.confirmadas = confirmadas;
        this.noConfirmadas = noConfirmadas;
    }

    public ResumenDTO() {
    }

    public int getConfirmadas() {
        return confirmadas;
    }

    public void setConfirmadas(int confirmadas) {
        this.confirmadas = confirmadas;
    }

    public int getNoConfirmadas() {
        return noConfirmadas;
    }

    public void setNoConfirmadas(int noConfirmadas) {
        this.noConfirmadas = noConfirmadas;
    }
}
