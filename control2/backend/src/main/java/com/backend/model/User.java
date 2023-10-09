package com.backend.model;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter private Long id;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
}
