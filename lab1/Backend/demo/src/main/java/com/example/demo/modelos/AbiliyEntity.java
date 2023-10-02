package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * Clase que representa una Ability
 */
@Entity
@Table(name = "Abiliy")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AbiliyEntity {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_ability;
        private String names;
        private String items;
        private String description;


}
