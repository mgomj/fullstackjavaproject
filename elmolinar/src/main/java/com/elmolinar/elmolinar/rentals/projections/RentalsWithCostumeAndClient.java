package com.elmolinar.elmolinar.rentals.projections;

import com.elmolinar.elmolinar.clients.projections.ClientWithoutRentals;
import com.elmolinar.elmolinar.costumes.projections.CostumeWithoutRentals;

public interface RentalsWithCostumeAndClient {
   
    int getId();
    String getRentalDate();
    String getReturnDate();
    int getPrice();
    int getQuantity();  
    ClientWithoutRentals getClient();
    CostumeWithoutRentals getCostume();

    default int getTotalPrice(){
        return getPrice() * getQuantity();
    }

}
