package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

/*
* Clase que representa un voluntario
* */

public class Voluntary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_voluntary;
    private String rut;
    private String fullname;
    private String birthday;
    private boolean state;
    private String email;
    private String password;
}
