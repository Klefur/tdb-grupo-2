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

        /**
         * Gets the ID of an Institution.
         * @return Integer
         */
        public Integer getId_institution() {
                return id_institution;
        }

        /**
         * Sets the ID of an Institution.
         * @param id_institution
         */
        public void setId_institution(Integer id_institution) {
                this.id_institution = id_institution;
        }

        /**
         * Gets the name of an Institution.
         * @return String
         */
        public String getName() {
                return name;
        }

        /**
         * Sets the name of an Institution.
         * @param name
         */
        public void setName(String name) {
                this.name = name;
        }

        /**
         * Gets the coordinator's name of an Institution.
         * @return String
         */
        public String getCoordinator_name() {
                return coordinator_name;
        }

        /**
         * Sets the coordinator's name of an Institution.
         * @param coordinator_name
         */
        public void setCoordinator_name(String coordinator_name) {
                this.coordinator_name = coordinator_name;
        }

        /**
         * Gets the email of an Institution.
         * @return String
         */
        public String getEmail() {
                return email;
        }

        /**
         * Sets the email of an Institution.
         * @param email
         */
        public void setEmail(String email) {
                this.email = email;
        }

        /**
         * Gets the password of an Institution.
         * @return String
         */
        public String getPassword() {
                return password;
        }

        /**
         * Sets the password of an Institution.
         * @param password
         */
        public void setPassword(String password) {
                this.password = password;
        }
}
