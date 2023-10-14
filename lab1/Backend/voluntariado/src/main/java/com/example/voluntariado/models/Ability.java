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
         * Obtiene el id de una Habilidad
         * @return Integer
         */
        public Integer getId_ability() {
                return id_ability;
        }

        /**
         * setea el id de una habilidad
         * @param id_ability
         */
        public void setId_ability(Integer id_ability) {
                this.id_ability = id_ability;
        }

        /**
         * Obtiene el nombre de una Habilidad
         * @return String
         */
        public String getNames() {
                return names;
        }

        /**
         * setea el nombre de una habilidad
         * @param names
         */
        public void setNames(String names) {
                this.names = names;
        }

        /**
         * Obtiene los items de una Habilidad
         * @return String
         */
        public String getItems() {
                return items;
        }

        /**
         * setea los items de una habilidad
         * @param items
         */
        public void setItems(String items) {
                this.items = items;
        }

        /**
         * Obtiene la descripcion de una Habilidad
         * @return String
         */
        public String getDescription() {
                return description;
        }

        /**
         * setea la descripcion de una habilidad
         * @param description
         */
        public void setDescription(String description) {
                this.description = description;
        }

        /**
         * Obtiene la informacion de una Habilidad
         * @return String
         */
}
