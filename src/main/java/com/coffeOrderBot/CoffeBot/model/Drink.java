package com.coffeOrderBot.CoffeBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "drinks")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Drink {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "volume")
    private String volume;

    @Column(name = "price")
    private Integer price;

    @Column(name = "milk_type")
    private String milkType;


}
