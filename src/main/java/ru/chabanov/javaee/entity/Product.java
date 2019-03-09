package ru.chabanov.javaee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Product extends Common {


    @Getter
    @Setter
    private int price;
    @Getter
    @Setter
    private Category category;

    public Product(String name, int price,Category category) {
        setName(name);
        this.price=price;
        this.category = category;
    }


}