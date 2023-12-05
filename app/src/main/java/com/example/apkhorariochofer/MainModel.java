package com.example.apkhorariochofer;
public class MainModel {

    private String uid, nombreR, apellidoPaternoR, apellidoMaternoR, direcionbaseR, horaEntradaR, horaSalidaR, correo, password;

    private String accessType;
    public MainModel() {
    }

    public MainModel(String uid, String nombreR, String apellidoPaternoR, String apellidoMaternoR, String direcionbaseR, String horaEntradaR, String horaSalidaR, String correoR, String passwordR, String accessType) {
        this.uid = uid;
        this.nombreR = nombreR;
        this.apellidoPaternoR = apellidoPaternoR;
        this.apellidoMaternoR = apellidoMaternoR;
        this.direcionbaseR = direcionbaseR;
        this.horaEntradaR = horaEntradaR;
        this.horaSalidaR = horaSalidaR;
        this.correo = correoR;
        this.password = passwordR;
        this.accessType = accessType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public String getApellidoPaternoR() {
        return apellidoPaternoR;
    }

    public void setApellidoPaternoR(String apellidoPaternoR) {
        this.apellidoPaternoR = apellidoPaternoR;
    }

    public String getApellidoMaternoR() {
        return apellidoMaternoR;
    }

    public void setApellidoMaternoR(String apellidoMaternoR) {
        this.apellidoMaternoR = apellidoMaternoR;
    }

    public String getDirecionbaseR() {
        return direcionbaseR;
    }

    public void setDirecionbaseR(String direcionbaseR) {
        this.direcionbaseR = direcionbaseR;
    }

    public String getHoraEntradaR() {
        return horaEntradaR;
    }

    public void setHoraEntradaR(String horaEntradaR) {
        this.horaEntradaR = horaEntradaR;
    }

    public String getHoraSalidaR() {
        return horaSalidaR;
    }

    public void setHoraSalidaR(String horaSalidaR) {
        this.horaSalidaR = horaSalidaR;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreR +
                ", Direccion de la base: " + direcionbaseR;
    }
}
