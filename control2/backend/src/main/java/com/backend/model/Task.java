package com.backend.model;

import lombok.Getter;
import lombok.Setter;

public class Task {
    @Getter @Setter private Long id;
    @Getter @Setter private String title;
    @Getter @Setter private String description;
    @Getter @Setter private Long id_user;
}
