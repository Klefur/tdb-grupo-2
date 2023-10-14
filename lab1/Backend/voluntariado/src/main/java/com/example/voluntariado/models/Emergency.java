package com.example.voluntariado.models;


/**
 * This class represents an emergency.
 */

public class Emergency {
        private Integer id_emergency;
        private String name;
        private String description;
        private String state;
        private Integer id_institution;



        // Getters
        public Integer getId_emergency() {
                return id_emergency;
        }

        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public String getState() {
                return state;
        }

        public Integer getId_institution() {
                return id_institution;
        }

        // Setters
        public void setId_emergency(Integer id_emergency) {
                this.id_emergency = id_emergency;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setState(String state) {
                this.state = state;
        }

        public void setId_institution(Integer id_institution) {
                this.id_institution = id_institution;
        }
}
