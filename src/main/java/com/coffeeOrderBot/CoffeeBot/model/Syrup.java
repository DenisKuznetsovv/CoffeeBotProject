package com.coffeeOrderBot.CoffeeBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "syrup")
//@RequiredArgsConstructor
//@Getter
//@Setter
@Data
public class Syrup {

    @Id
    private Long syrup_id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    public Syrup(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
