package com.elmolinar.elmolinar.clients;

import java.util.List;

import com.elmolinar.elmolinar.rentals.Rental;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String troupe;
    private String email;
  
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Rental> rentals;

    public void setClients(Object object) {
    }

}
