package com.example.demo.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Voluntary")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Voluntary {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_voluntary;
    private String rut;
    private String fullname;
    private String birthday;
    private boolean state;
    private String email;
    private String password;

}
