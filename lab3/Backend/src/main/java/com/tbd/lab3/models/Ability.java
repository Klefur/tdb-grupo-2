package com.tbd.lab3.models;

import java.util.List;

/**
 * This class represents an ability.
 */
public class Ability {
        private Integer id_ability;
        private String code;
        private String name;
        private List<String> items;
        private String description;


        /**
         * Gets the ID of an Ability.
         * @return Integer
         */
        public Integer getId_ability() {
                return id_ability;
        }


        /**
         * Gets the code of an Ability.
         * @return String
         */
        public String getCode(){return  code;}


        /**
         * Sets the code of an ability.
         * @param code
         */
        public void setId_code(String code) {
                this.code = code;
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
                return name;
        }

        /**
         * Sets the name of an ability.
         * @param names
         */
        public void setNames(String names) {
                this.name = names;
        }

        /**
         * Gets the items associated with an Ability.
         * @return String
         */
        public List<String> getItems() {
                return items;
        }

        /**
         * Sets the items associated with an ability.
         * @param items
         */
        public void setItems(List<String> items) {
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
