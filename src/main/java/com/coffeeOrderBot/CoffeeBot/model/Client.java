package com.coffeeOrderBot.CoffeeBot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Entity(name = "clients")
@Getter
@Setter
@RequiredArgsConstructor
public class Client {

    @Id
    private Long client_id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String secondName;

    @Column(name = "register_day")
    private Timestamp registerDay;

    @ManyToOne()
    @JoinColumn(name = "syrup_id")
    private Syrup syrupId;

    @ManyToOne()
    @JoinColumn(name = "drink_id")
    private DrinkMenu drinkId;

    @Column(name = "comment")
    private String comment;

    private String volume;

    private String favorite_drink;


    public String getOrderInformation(){
        return "Имя: " + firstName + "\n" +
                "Заказ: " + "\n" +
                favorite_drink + " " + volume + " " + comment;
    }
    public String getInformOfDrink(){
        return favorite_drink + " " + "объем " + volume + "\n" + comment;
    }

}
