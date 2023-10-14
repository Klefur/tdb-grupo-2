package com.example.voluntariado.models;

/**
 * This class represents a voluntary with an ability.
 */
public class Voluntary_Ability {
        private Integer id_voluntary_ability;
        private Integer id_voluntary;
        private Integer id_ability;

        // Getters and Setters

        /**
         * Gets the ID of a Voluntary Ability.
         * @return Integer
         */
        public Integer getId_voluntary_ability() {
                return id_voluntary_ability;
        }

        /**
         * Sets the ID of a Voluntary Ability.
         * @param id_voluntary_ability
         */
        public void setId_voluntary_ability(Integer id_voluntary_ability) {
                this.id_voluntary_ability = id_voluntary_ability;
        }

        /**
         * Gets the ID of the voluntary associated with a Voluntary Ability.
         * @return Integer
         */
        public Integer getId_voluntary() {
                return id_voluntary;
        }

        /**
         * Sets the ID of the voluntary associated with a Voluntary Ability.
         * @param id_voluntary
         */
        public void setId_voluntary(Integer id_voluntary) {
                this.id_voluntary = id_voluntary;
        }

        /**
         * Gets the ID of the ability associated with a Voluntary Ability.
         * @return Integer
         */
        public Integer getId_ability() {
                return id_ability;
        }

        /**
         * Sets the ID of the ability associated with a Voluntary Ability.
         * @param id_ability
         */
        public void setId_ability(Integer id_ability) {
                this.id_ability = id_ability;
        }
}
