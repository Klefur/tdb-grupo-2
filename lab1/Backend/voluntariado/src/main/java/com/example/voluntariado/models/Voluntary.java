package com.example.voluntariado.models;


/*
* This class represents a voluntary.
* */




public class Voluntary {
    private Integer id_voluntary;
    private String rut;
    private String fullname;
    private String birthday;
    private Integer state;
    private String email;
    private String password;


    // Getters and Setters

    public Integer getId_voluntary() {
        return id_voluntary;
    }

    public void setId_voluntary(Integer id_voluntary) {
        this.id_voluntary = id_voluntary;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
