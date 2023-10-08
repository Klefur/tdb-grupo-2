package com.example.voluntariado.models;


/*
* Clase que representa una tarea
* */

import lombok.Data;

@Data
public class Task {
    private Integer id_task;
    private String name;
    private String description;
    private boolean state;
    private Integer id_institution;
}
