package com.example.voluntariado.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Clase que representa un voluntario con una habilidad
 */

public class Voluntary_Ability {
        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_voluntary_ability;
        private Integer id_voluntary;
        private Integer id_ability;
}
