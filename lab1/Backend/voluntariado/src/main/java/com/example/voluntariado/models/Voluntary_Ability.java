package com.example.voluntariado.models;



/**
 * This class represents a voluntary with an ability.
 */


public class Voluntary_Ability {
        private Integer id_voluntary_ability;
        private Integer id_voluntary;
        private Integer id_ability;

        // Getters and Setters

        public Integer getId_voluntary_ability() {
                return id_voluntary_ability;
        }

        public void setId_voluntary_ability(Integer id_voluntary_ability) {
                this.id_voluntary_ability = id_voluntary_ability;
        }

        public Integer getId_voluntary() {
                return id_voluntary;
        }

        public void setId_voluntary(Integer id_voluntary) {
                this.id_voluntary = id_voluntary;
        }

        public Integer getId_ability() {
                return id_ability;
        }

        public void setId_ability(Integer id_ability) {
                this.id_ability = id_ability;
        }
}
