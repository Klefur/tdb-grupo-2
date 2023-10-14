package com.example.voluntariado.models;


/**
 * This class represents an institution.
 */


public class Institution {
        private Integer id_institution;
        private String name;
        private String coordinator_name;
        private String email;
        private String password;

        // Getters and Setters

        public Integer getId_institution() {
                return id_institution;
        }

        public void setId_institution(Integer id_institution) {
                this.id_institution = id_institution;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCoordinator_name() {
                return coordinator_name;
        }

        public void setCoordinator_name(String coordinator_name) {
                this.coordinator_name = coordinator_name;
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
