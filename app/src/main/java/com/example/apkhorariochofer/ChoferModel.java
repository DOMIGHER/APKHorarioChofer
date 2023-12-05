package com.example.apkhorariochofer;

public class ChoferModel {
    private String uid, correo, password, nombreC, apellidoPaternoC, apellidoMaternoC, licenciaconducirC, curpC, domicilioC, antecedentesPenalesC, rutaC;

    private String accessType;
    public ChoferModel() {
    }

    public ChoferModel(String uid, String correoC, String passwordC, String nombreC, String apellidoPaternoC, String apellidoMaternoC, String licenciaconducirC, String curpC, String domicilioC, String antecedentesPenalesC, String rutaC, String accessType) {
        this.uid = uid;
        this.correo = correoC;
        this.password = passwordC;
        this.nombreC = nombreC;
        this.apellidoPaternoC = apellidoPaternoC;
        this.apellidoMaternoC = apellidoMaternoC;
        this.licenciaconducirC = licenciaconducirC;
        this.curpC = curpC;
        this.domicilioC = domicilioC;
        this.antecedentesPenalesC = antecedentesPenalesC;
        this.rutaC = rutaC;
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

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getApellidoPaternoC() {
        return apellidoPaternoC;
    }

    public void setApellidoPaternoC(String apellidoPaternoC) {
        this.apellidoPaternoC = apellidoPaternoC;
    }

    public String getApellidoMaternoC() {
        return apellidoMaternoC;
    }

    public void setApellidoMaternoC(String apellidoMaternoC) {
        this.apellidoMaternoC = apellidoMaternoC;
    }

    public String getLicenciaconducirC() {
        return licenciaconducirC;
    }

    public void setLicenciaconducirC(String licenciaconducirC) {
        this.licenciaconducirC = licenciaconducirC;
    }

    public String getCurpC() {
        return curpC;
    }

    public void setCurpC(String curpC) {
        this.curpC = curpC;
    }

    public String getDomicilioC() {
        return domicilioC;
    }

    public void setDomicilioC(String domicilioC) {
        this.domicilioC = domicilioC;
    }

    public String getAntecedentesPenalesC() {
        return antecedentesPenalesC;
    }

    public void setAntecedentesPenalesC(String antecedentesPenalesC) {
        this.antecedentesPenalesC = antecedentesPenalesC;
    }

    public String getRutaC() {
        return rutaC;
    }

    public void setRutaC(String rutaC) {
        this.rutaC = rutaC;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreC + ", Ruta: " + rutaC;
    }
}
