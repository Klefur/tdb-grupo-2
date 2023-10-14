package com.example.voluntariado.models;

/**
 * This class represents an ability.
 */
public class Ability {
        private Integer id_ability;
        private String names;
        private String items;
        private String description;

        /**
         * Gets the ID of an Ability.
         * @return Integer
         */
        public Integer getId_ability() {
                return id_ability;
        }

        /**
         * Sets the ID of an ability.
         * @param id_ability
         */
        public void setId_ability(Integer id_ability) {
                this.id_ability = id_ability;
        }

        /**
         * Gets the name of an Ability.
         * @return String
         */
        public String getNames() {
                return names;
        }

        /**
         * Sets the name of an ability.
         * @param names
         */
        public void setNames(String names) {
                this.names = names;
        }

        /**
         * Gets the items associated with an Ability.
         * @return String
         */
        public String getItems() {
                return items;
        }

        /**
         * Sets the items associated with an ability.
         * @param items
         */
        public void setItems(String items) {
                this.items = items;
        }

        /**
         * Gets the description of an Ability.
         * @return String
         */
        public String getDescription() {
                return description;
        }

        /**
         * Sets the description of an ability.
         * @param description
         */
        public void setDescription(String description) {
                this.description = description;
        }

        /**
         * Gets the information of an Ability.
         * @return String
         */
}
