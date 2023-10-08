package com.example.voluntariado.models;

import lombok.Data;

/**
 * This class represents a task with an ability.
 */

@Data
public class Task_Ability {
        private Integer id_task_ability;
        private Integer id_task;
        private Integer id_ability;
}
