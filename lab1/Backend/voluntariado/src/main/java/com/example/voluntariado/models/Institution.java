package com.example.voluntariado.models;

import lombok.Data;

/**
 * This class represents an institution.
 */

@Data
public class Institution {
        private Integer id_institution;
        private String name;
        private String coordinator_name;
        private String email;
        private String password;
}
