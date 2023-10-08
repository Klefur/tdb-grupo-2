package com.example.voluntariado.models;

import lombok.Data;

/**
 * Clase que representa una tarea con una habilidad
 */

@Data
public class Task_Ability {

        private Integer id_task_ability;
        private Integer id_task;
        private Integer id_ability;
}
