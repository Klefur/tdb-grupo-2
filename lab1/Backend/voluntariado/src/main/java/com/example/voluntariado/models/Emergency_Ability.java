package com.example.voluntariado.models;

/**
 * This class represents an emergency with one ability or more.
 */
public class Emergency_Ability {
        private Integer id_emergency_ability;
        private Integer id_emergency;
        private Integer id_ability;

        // Getters
        /**
         * Gets the ID of an Emergency Ability.
         * @return Integer
         */
        public Integer getId_emergency_ability() {
                return id_emergency_ability;
        }

        /**
         * Gets the ID of the emergency associated with an Emergency Ability.
         * @return Integer
         */
        public Integer getId_emergency() {
                return id_emergency;
        }

        /**
         * Gets the ID of the ability associated with an Emergency Ability.
         * @return Integer
         */
        public Integer getId_ability() {
                return id_ability;
        }

        // Setters
        /**
         * Sets the ID of an Emergency Ability.
         * @param id_emergency_ability
         */
        public void setId_emergency_ability(Integer id_emergency_ability) {
                this.id_emergency_ability = id_emergency_ability;
        }

        /**
         * Sets the ID of the emergency associated with an Emergency Ability.
         * @param id_emergency
         */
        public void setId_emergency(Integer id_emergency) {
                this.id_emergency = id_emergency;
        }

        /**
         * Sets the ID of the ability associated with an Emergency Ability.
         * @param id_ability
         */
        public void setId_ability(Integer id_ability) {
                this.id_ability = id_ability;
        }
}
