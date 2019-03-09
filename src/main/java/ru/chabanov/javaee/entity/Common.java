package ru.chabanov.javaee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



public abstract class Common {
    @ToString.Exclude
    private static int counterId=0;

    @Getter
    @Setter
    private String id =""+ ++counterId;
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String description;
}
