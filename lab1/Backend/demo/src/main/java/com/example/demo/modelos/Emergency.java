package com.example.demo.modelos;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import lombok.*;

import java.util.Date;

/**
 * Clase que representa una Emergencia
 */
@Entity
@Table(name = "Emergency")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emergency {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_emergency;
        private String name;
        private String description;
        private Date date;
        private String state;
        private Integer id_intitution;


}
