package com.coffeeOrderBot.CoffeeBot.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrinkMenuRepository extends CrudRepository<DrinkMenu, Long> {

    List<DrinkMenu> findByName(String name);
}
