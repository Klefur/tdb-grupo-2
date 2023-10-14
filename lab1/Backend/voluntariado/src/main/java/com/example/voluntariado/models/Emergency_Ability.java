package com.example.voluntariado.models;


/**
 * This class represents an emergency with one ability or more.
 */

public class Emergency_Ability {
        private Integer id_emergency_ability;
        private Integer id_emergency;
        private Integer id_ability;


        // Getters
        public Integer getId_emergency_ability() {
                return id_emergency_ability;
        }

        public Integer getId_emergency() {
                return id_emergency;
        }

        public Integer getId_ability() {
                return id_ability;
        }

        // Setters
        public void setId_emergency_ability(Integer id_emergency_ability) {
                this.id_emergency_ability = id_emergency_ability;
        }

        public void setId_emergency(Integer id_emergency) {
                this.id_emergency = id_emergency;
        }

        public void setId_ability(Integer id_ability) {
                this.id_ability = id_ability;
        }
}
