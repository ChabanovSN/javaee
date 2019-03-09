package ru.chabanov.javaee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Category extends Common {
    public Category(String name,String description) {
       setName(name);
       setDescription(description);
    }
}
