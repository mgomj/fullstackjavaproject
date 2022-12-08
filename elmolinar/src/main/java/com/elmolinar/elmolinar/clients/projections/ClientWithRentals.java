package com.elmolinar.elmolinar.clients.projections;

import java.util.List;

import com.elmolinar.elmolinar.rentals.projections.RentalsWithCostumeAndClient;


public interface ClientWithRentals extends ClientWithoutRentals{
    
    List<RentalsWithCostumeAndClient> getRentals();
}
