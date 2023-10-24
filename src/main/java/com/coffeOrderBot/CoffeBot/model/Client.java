package com.coffeOrderBot.CoffeBot.model;

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

    @Column(name = "userName")
    private String userName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @Column(name = "RegisterDay")
    private Timestamp registerDay;

    @ManyToOne()
    @JoinColumn(name = "syrup_id")
    private Syrup syrupId;

    @ManyToOne()
    @JoinColumn(name = "drink_id")
    private DrinkMenu drinkId;

    @Column(name = "Comment")
    private String comment;

    private String volume;

    private String favorite_drink;


    public String getOrderInformation(){
        return "Имя: " + firstName + "\n" +
                "Заказ: " + "\n" +
                favorite_drink + " " + volume + " " + comment;
    }
    public String getInformOfDrink(){
        return favorite_drink + " " + volume + "\n" + comment;
    }

}
