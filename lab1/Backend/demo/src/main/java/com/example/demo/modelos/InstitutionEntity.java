package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Clase que representa una Institucion
 */
@Entity
@Table(name = "Institution")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class InstitutionEntity {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_institution;
        private String name;
        private String coordinator_name;
        private String email;
        private String password;


}
