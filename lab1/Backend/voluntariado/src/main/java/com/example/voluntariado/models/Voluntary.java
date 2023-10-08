package com.example.voluntariado.models;


/*
* Clase que representa un voluntario
* */

import lombok.Data;

@Data
public class Voluntary {
    private Integer id_voluntary;
    private String rut;
    private String fullname;
    private String birthday;
    private int state;
    private String email;
    private String password;
}
