package com.elmolinar.elmolinar.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elmolinar.elmolinar.clients.projections.ClientWithRentals;
import com.elmolinar.elmolinar.clients.projections.ClientWithoutRentals;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {
    
    List<ClientWithoutRentals> findByNameContaining(String name);

    List<ClientWithoutRentals> findBy();

    Optional<ClientWithRentals> findClientById(int id);
}