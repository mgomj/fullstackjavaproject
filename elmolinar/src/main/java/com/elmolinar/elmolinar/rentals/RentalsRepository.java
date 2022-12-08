package com.elmolinar.elmolinar.rentals;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elmolinar.elmolinar.rentals.projections.RentalsWithCostumeAndClient;

@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer> {
    
    Optional<RentalsWithCostumeAndClient> findRentalById(int id);

    List<RentalsWithCostumeAndClient> findBy();
}

