package com.elmolinar.elmolinar.costumes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elmolinar.elmolinar.costumes.projections.CostumeWithRentals;
import com.elmolinar.elmolinar.costumes.projections.CostumeWithoutRentals;

@Repository
public interface CostumesRepository extends JpaRepository<Costume, Integer> {
    
    List<CostumeWithoutRentals> findByNameContaining(String name);

    List<CostumeWithoutRentals> findBy();

    Optional<CostumeWithRentals> findCostumeById(int id);
}