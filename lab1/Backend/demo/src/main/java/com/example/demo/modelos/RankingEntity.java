package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Clase que representa una Rankig
 */
@Entity
@Table(name = "Ranking")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RankingEntity {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_ranking;
        private Integer id_task;
        private Integer id_voluntary;



}
