package com.coffeOrderBot.CoffeBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Timestamp;


@Entity(name = "client")
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

    public Client(Long id, String userName, String firstName, String secondName, Timestamp registerDay) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.registerDay = registerDay;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFavorite_drink() {
        return favorite_drink;
    }

    public void setFavorite_drink(String favorite_drink) {
        this.favorite_drink = favorite_drink;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", registerDay=" + registerDay +
                '}';
    }

    public String getOrderInformation(){
        return "Имя: " + firstName + "\n" +
                "Заказ: " + "\n" +
                favorite_drink + " " + volume + " " + comment;

    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Timestamp getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(Timestamp registerDay) {
        this.registerDay = registerDay;
    }
}
