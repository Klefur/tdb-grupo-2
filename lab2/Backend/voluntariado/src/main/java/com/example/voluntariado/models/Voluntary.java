package com.example.voluntariado.models;

import java.awt.*;

/**
 * This class represents a voluntary.
 */
public class Voluntary {
    private Integer id_voluntary;
    private String rut;
    private String fullname;
    private String birthday;
    private Integer state;
    private String email;
    private String password;
    private Double latitude;
    private Double longitude;

    private Point geom;

    // Getters and Setters

    /**
     * Gets the ID of a Voluntary.
     * @return Integer
     */
    public Integer getId_voluntary() {
        return id_voluntary;
    }

    /**
     * Sets the ID of a Voluntary.
     * @param id_voluntary
     */
    public void setId_voluntary(Integer id_voluntary) {
        this.id_voluntary = id_voluntary;
    }

    /**
     * Gets the RUT (national identification number) of a Voluntary.
     * @return String
     */
    public String getRut() {
        return rut;
    }

    /**
     * Sets the RUT of a Voluntary.
     * @param rut
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Gets the full name of a Voluntary.
     * @return String
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the full name of a Voluntary.
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets the birthday of a Voluntary.
     * @return String
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of a Voluntary.
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the state of a Voluntary.
     * @return Integer
     */
    public Integer getState() {
        return state;
    }

    /**
     * Sets the state of a Voluntary.
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * Gets the email of a Voluntary.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of a Voluntary.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of a Voluntary.
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of a Voluntary.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Double getLatitude(){
        return latitude;
    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public Double getLongitude(){
        return longitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    public Point getGeom(){
        return geom;
    }

    public void setGeom(Point geom){
        this.geom = geom;
    }
}
