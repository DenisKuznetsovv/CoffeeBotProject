package com.coffeOrderBot.CoffeBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@Entity(name = "client")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Client {

    @Id
    private Long id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @Column(name = "RegisterDay")
    private Timestamp registerDay;

    @Column(name = "Favorite_drink")
    private String favorite_drink;

    @Column(name = "Volume")
    private String volume;

    @Column(name = "Comment")
    private String comment;

    public String getOrderInformation(){
        return "Имя: " + firstName + "\n" +
                "Заказ: " + "\n" +
                favorite_drink + " " + volume + " " + comment;
    }
    public String getInformOfDrink(){
        return favorite_drink + " " + volume + "\n" + comment;
    }

}
