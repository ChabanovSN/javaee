package ru.chabanov.javaee.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends Common implements Serializable {
    @OneToMany(
            mappedBy = "category",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @Setter
    @Getter
    private List<Product> products;


    public Category(String name,String description) {
       setName(name);
       setDescription(description);
    }
}
