package ru.chabanov.javaee.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public abstract class Common {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;



    @Column(name = "description")
    private String description;
}
