package com.elmolinar.elmolinar.costumes.projections;

import java.util.List;

import com.elmolinar.elmolinar.clients.projections.ClientWithoutRentals;
import com.elmolinar.elmolinar.rentals.projections.RentalsWithCostumeAndClient;

public interface CostumeWithRentals extends ClientWithoutRentals{

    List<RentalsWithCostumeAndClient> getRentals();
}
