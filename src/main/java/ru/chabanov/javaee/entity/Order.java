package ru.chabanov.javaee.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends Common implements Serializable {


    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @Setter
    @Getter
    private List<Product> products;


    public Order (String name,String description) {
        setName(name);
        setDescription(description);
    }
}
