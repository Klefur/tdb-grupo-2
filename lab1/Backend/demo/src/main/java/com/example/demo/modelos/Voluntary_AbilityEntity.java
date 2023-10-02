package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * Clase que representa una
 */
@Entity
@Table(name = "Voluntary_Ability")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Voluntary_AbilityEntity {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_voluntary_ability;
        private Integer id_voluntary;
        private Integer id_ability;




}
