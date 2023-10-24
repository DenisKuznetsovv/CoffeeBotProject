package com.coffeOrderBot.CoffeBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "syrup")
@RequiredArgsConstructor
@Getter
@Setter
public class Syrup {

    @Id
    private Long syrup_id;

    @Column(name = "name")
    private String name;
}
