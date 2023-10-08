package com.example.voluntariado.models;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import lombok.*;

import java.util.Date;

/**
 * Clase que representa una emergencia
 */
public class Emergency {
        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_emergency;
        private String name;
        private String description;
        private Date date;
        private String state;
        private Integer id_institution;
}
