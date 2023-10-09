package com.example.voluntariado.models;


/*
* This class represents a task.
* */

import lombok.Data;

@Data
public class Task {
    private Integer id_task;
    private String name;
    private String description;
    private Integer state;

    private Integer id_emergency;

    private Integer id_institution;

}
