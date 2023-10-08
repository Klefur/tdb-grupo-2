package com.example.voluntariado.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Clase que representa una emergencia con habilidad
 */
public class Emergency_Ability {
        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_emergency_ability;
        private Integer id_emergency;
        private Integer id_ability;
}
