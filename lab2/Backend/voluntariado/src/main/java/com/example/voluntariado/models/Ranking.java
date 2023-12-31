package com.example.voluntariado.models;

/**
 * This class represents a ranking.
 */
public class Ranking {
        private Integer id_ranking;
        private Integer id_task;
        private Integer id_voluntary;
        private Integer matched_abilities_count;

        // Getters and Setters

        /**
         * Gets the ID of a Ranking.
         * @return Integer
         */
        public Integer getId_ranking() {
                return id_ranking;
        }

        /**
         * Sets the ID of a Ranking.
         * @param id_ranking
         */
        public void setId_ranking(Integer id_ranking) {
                this.id_ranking = id_ranking;
        }

        /**
         * Gets the ID of the task associated with a Ranking.
         * @return Integer
         */
        public Integer getId_task() {
                return id_task;
        }

        /**
         * Sets the ID of the task associated with a Ranking.
         * @param id_task
         */
        public void setId_task(Integer id_task) {
                this.id_task = id_task;
        }

        /**
         * Gets the ID of the voluntary associated with a Ranking.
         * @return Integer
         */
        public Integer getId_voluntary() {
                return id_voluntary;
        }

        /**
         * Sets the ID of the voluntary associated with a Ranking.
         * @param id_voluntary
         */
        public void setId_voluntary(Integer id_voluntary) {
                this.id_voluntary = id_voluntary;
        }

        public Integer getMatched_abilities_count(){
                return matched_abilities_count;
        }

        public void setMatched_abilities_count(Integer matched_abilities_count){
                this.matched_abilities_count = matched_abilities_count;
        }
}
