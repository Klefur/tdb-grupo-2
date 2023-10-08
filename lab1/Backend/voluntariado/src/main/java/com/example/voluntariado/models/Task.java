package com.example.demo.modelos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;


/*
* Clase que representa una tarea
* */

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_task;
    private String name;
    private String description;
    private Date date;
    private boolean state;
    private Integer id_institution;
}
