package com.example.voluntariado.models;

import lombok.Data;

/**
 * Clase que representa una emergencia
 */
@Data
public class Emergency {
        private Integer id_emergency;
        private String name;
        private String description;
        private String state;
        private Integer id_institution;
}
