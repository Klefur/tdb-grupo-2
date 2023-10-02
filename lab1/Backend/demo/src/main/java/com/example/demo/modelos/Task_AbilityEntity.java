package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Clase que representa una Task_Ability
 */
@Entity
@Table(name = "Task_Ability")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task_AbilityEntity {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_task_ability;
        private Integer id_task;
        private Integer id_ability;


}
