package com.example.voluntariado.models;

import lombok.Data;

/**
 * This class represents an emergency with one ability or more.
 */
@Data
public class Emergency_Ability {
        private Integer id_emergency_ability;
        private Integer id_emergency;
        private Integer id_ability;
}
