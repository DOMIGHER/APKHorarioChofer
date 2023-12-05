package com.example.apkhorariochofer;

public class MainAdmin {

    private String uid, correo, password, nombreA;

    private String accessType;

    public MainAdmin() {
    }

    public MainAdmin(String uid, String correoA, String passwordA, String nombreA, String accessType) {
        this.uid = uid;
        this.correo = correoA;
        this.password = passwordA;
        this.nombreA = nombreA;
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

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getAccessType() {
        return accessType;
    }
    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}
