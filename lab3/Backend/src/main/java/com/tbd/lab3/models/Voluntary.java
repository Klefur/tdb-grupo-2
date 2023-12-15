package com.tbd.lab3.models;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.print.DocFlavor;


/**
 * This class represents a voluntary.
 */

@Document(collection = "Voluntary")
public class Voluntary {
    @Id
    private ObjectId _id;
    private String rut;
    private String fullname;
    private String birthday;
    private Integer state;
    private Double latitude;
    private Double longitude;
    private String geom;

    private List<Ability> abilities;

    // Getters and Setters

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

    public List<Ability> getAbilities() {
        return abilities;
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

    public String getGeom(){
        return geom;
    }

    public void setGeom(String geom){
        this.geom = geom;
    }



    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
