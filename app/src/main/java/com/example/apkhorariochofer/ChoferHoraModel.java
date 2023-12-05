package com.example.apkhorariochofer;

public class ChoferHoraModel {

    String uid, horaEntrada, horaSalida;

    public ChoferHoraModel() {
    }

    public ChoferHoraModel(String uid, String horaEntrada, String horaSalida) {
        this.uid = uid;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Hora de Entrada: " + horaEntrada + ", Hora de Salida: " + horaSalida;
    }
}
