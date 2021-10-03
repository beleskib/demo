package com.example.demo.Model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer noRooms;
    private Integer pricePerNight;

    public Hotel(String name, Integer noRooms, Integer pricePerNight, Integer stars) {
        this.name = name;
        this.noRooms = noRooms;
        this.pricePerNight = pricePerNight;
        this.stars = stars;
    }

    private Integer stars;

    public Hotel() {

    }
}