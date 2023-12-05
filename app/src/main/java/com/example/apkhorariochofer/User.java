package com.example.apkhorariochofer;

public class User {
    private String correo;
    private String password;

    private String accessType;

    public User() {
    }

    public User(String correo, String password, String accessType) {
        this.correo = correo;
        this.password = password;
        this.accessType = accessType;
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

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}
