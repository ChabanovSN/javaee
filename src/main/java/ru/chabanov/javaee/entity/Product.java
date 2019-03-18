package ru.chabanov.javaee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product extends Common implements Serializable {


    @Getter
    @Setter
    @NotNull
    @Column(name = "price")
    private BigDecimal price;


    @Getter
    @Setter
    @NotNull
    @ManyToOne
    private Category category;

    public Product(String name, BigDecimal price,Category category) {
        setName(name);
        this.price=price;
        this.category = category;
    }


}