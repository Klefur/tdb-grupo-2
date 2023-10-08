package com.example.voluntariado.models;


/*
* This class represents a voluntary.
* */

import lombok.Data;

@Data
public class Voluntary {
    private Integer id_voluntary;
    private String rut;
    private String fullname;
    private String birthday;
    private Integer state;
    private String email;
    private String password;
}
