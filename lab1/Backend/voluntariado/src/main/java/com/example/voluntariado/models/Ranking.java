package com.example.voluntariado.models;


/**
 * This class represents a ranking.
 */

public class Ranking {
        private Integer id_ranking;
        private Integer id_task;
        private Integer id_voluntary;

        // Getters and Setters

        public Integer getId_ranking() {
                return id_ranking;
        }

        public void setId_ranking(Integer id_ranking) {
                this.id_ranking = id_ranking;
        }

        public Integer getId_task() {
                return id_task;
        }

        public void setId_task(Integer id_task) {
                this.id_task = id_task;
        }

        public Integer getId_voluntary() {
                return id_voluntary;
        }

        public void setId_voluntary(Integer id_voluntary) {
                this.id_voluntary = id_voluntary;
        }
}
