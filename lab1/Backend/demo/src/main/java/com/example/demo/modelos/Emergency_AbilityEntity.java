package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Clase que representa una Emergency_Ability
 */
@Entity
@Table(name = "Emergency_Ability")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emergency_AbilityEntity {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_emergency_ability;
        private Integer id_emergency;
        private Integer id_ability;


}
