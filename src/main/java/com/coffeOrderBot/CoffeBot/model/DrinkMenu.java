package com.coffeOrderBot.CoffeBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "drinks")
@RequiredArgsConstructor
@Getter
@Setter
public class DrinkMenu {

    @Id
    private Long drink_id;

    @Column(name = "name")
    private String name;

    @Column(name = "volume")
    private String volume;

    @Column(name = "price")
    private Integer price;

    @Column(name = "milk_type")
    private String milkType;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "menu_type")
    private String menuType;


}
