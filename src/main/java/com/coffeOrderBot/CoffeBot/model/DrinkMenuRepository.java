package com.coffeOrderBot.CoffeBot.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrinkMenuRepository extends CrudRepository<DrinkMenu, Long> {

    List<DrinkMenu> findByName(String name);

//    List<DrinkMenu> findAllMenuType();

//    DrinkMenu findByNameAndVolumeAndMilkType(String name, String volume, String milkType);
}
