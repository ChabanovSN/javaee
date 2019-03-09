package ru.chabanov.javaee.entity;


import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Order extends Common {


    public Order (String name,String description) {
        setName(name);
        setDescription(description);
    }
}
