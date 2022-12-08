package com.elmolinar.elmolinar.costumes;

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
@Data @AllArgsConstructor @NoArgsConstructor
public class Costume{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy = "costume", cascade = CascadeType.PERSIST)
    private List<Rental> rentals;

    public void setCostumes(Object object) {
    }

}

