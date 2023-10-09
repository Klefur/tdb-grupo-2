package com.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Task {
    @Getter @Setter private Long id;
    @Getter @Setter private String title;
    @Getter @Setter private String description;
    @Getter @Setter private Date expire_date;
    @Getter @Setter private Boolean completed;
    @Getter @Setter private Long id_user;
}
