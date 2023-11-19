package com.example.voluntariado.models;

public class Emergency_Voluntary {
    private Integer id_emergency_voluntary;

    private Integer id_emergency;
    private Integer id_voluntary;

    public Integer getId_emergency_voluntary() {
        return id_emergency_voluntary;
    }

    public void setId_emergency_voluntary(Integer id_emergency_voluntary) {
        this.id_emergency_voluntary = id_emergency_voluntary;
    }

    public Integer getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(Integer id_emergency) {
        this.id_emergency = id_emergency;
    }

    public Integer getId_voluntary() {
        return id_voluntary;
    }

    public void setId_voluntary(Integer id_voluntary) {
        this.id_voluntary = id_voluntary;
    }
}
