package com.elmolinar.elmolinar.rentals;

import com.elmolinar.elmolinar.clients.Client;
import com.elmolinar.elmolinar.costumes.Costume;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Rental{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;   
    private String rentalDate;
    private String returnDate;
    private int price;
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clientId") 
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costumeId") 
    private Costume costume;
}



