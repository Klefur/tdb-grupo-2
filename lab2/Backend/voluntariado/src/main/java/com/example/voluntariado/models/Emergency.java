package com.example.voluntariado.models;

import java.awt.*;

/**
 * This class represents an emergency.
 */
public class Emergency {
        private Integer id_emergency;
        private String name;
        private String description;
        private String state;
        private Integer id_institution;
        private Double latitude;
        private Double longitude;

        // Getters
        /**
         * Gets the ID of an Emergency.
         * @return Integer
         */
        public Integer getId_emergency() {
                return id_emergency;
        }

        /**
         * Gets the name of an Emergency.
         * @return String
         */
        public String getName() {
                return name;
        }

        /**
         * Gets the description of an Emergency.
         * @return String
         */
        public String getDescription() {
                return description;
        }

        /**
         * Gets the state of an Emergency.
         * @return String
         */
        public String getState() {
                return state;
        }

        /**
         * Gets the ID of the institution associated with an Emergency.
         * @return Integer
         */
        public Integer getId_institution() {
                return id_institution;
        }

        public Double getLatitude(){
                return latitude;
        }

        public Double getLongitude(){
                return longitude;
        }

        // Setters
        /**
         * Sets the ID of an Emergency.
         * @param id_emergency
         */
        public void setId_emergency(Integer id_emergency) {
                this.id_emergency = id_emergency;
        }

        /**
         * Sets the name of an Emergency.
         * @param name
         */
        public void setName(String name) {
                this.name = name;
        }

        /**
         * Sets the description of an Emergency.
         * @param description
         */
        public void setDescription(String description) {
                this.description = description;
        }

        /**
         * Sets the state of an Emergency.
         * @param state
         */
        public void setState(String state) {
                this.state = state;
        }

        /**
         * Sets the ID of the institution associated with an Emergency.
         * @param id_institution
         */
        public void setId_institution(Integer id_institution) {
                this.id_institution = id_institution;
        }

        public void setLatitude(Double latitude){
                this.latitude = latitude;
        }

        public void setLongitude(Double longitude){
                this.longitude = longitude;
        }
}
