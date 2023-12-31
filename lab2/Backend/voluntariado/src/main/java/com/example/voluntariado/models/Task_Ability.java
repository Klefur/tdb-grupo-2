package com.example.voluntariado.models;

/**
 * This class represents a task with an ability.
 */
public class Task_Ability {
        private Integer id_task_ability;
        private Integer id_task;
        private Integer id_ability;

        // Getters and Setters

        /**
         * Gets the ID of a Task Ability.
         * @return Integer
         */
        public Integer getId_task_ability() {
                return id_task_ability;
        }

        /**
         * Sets the ID of a Task Ability.
         * @param id_task_ability
         */
        public void setId_task_ability(Integer id_task_ability) {
                this.id_task_ability = id_task_ability;
        }

        /**
         * Gets the ID of the task associated with a Task Ability.
         * @return Integer
         */
        public Integer getId_task() {
                return id_task;
        }

        /**
         * Sets the ID of the task associated with a Task Ability.
         * @param id_task
         */
        public void setId_task(Integer id_task) {
                this.id_task = id_task;
        }

        /**
         * Gets the ID of the ability associated with a Task Ability.
         * @return Integer
         */
        public Integer getId_ability() {
                return id_ability;
        }

        /**
         * Sets the ID of the ability associated with a Task Ability.
         * @param id_ability
         */
        public void setId_ability(Integer id_ability) {
                this.id_ability = id_ability;
        }
}
