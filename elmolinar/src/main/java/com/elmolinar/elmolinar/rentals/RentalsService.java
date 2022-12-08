package com.elmolinar.elmolinar.rentals;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.elmolinar.elmolinar.clients.Client;
import com.elmolinar.elmolinar.clients.ClientsRepository;
import com.elmolinar.elmolinar.costumes.Costume;
import com.elmolinar.elmolinar.costumes.CostumesRepository;
import com.elmolinar.elmolinar.rentals.projections.RentalsWithCostumeAndClient;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class RentalsService {
    private final RentalsRepository rentalsRepository;
    private final CostumesRepository costumesRepository;
    private final ClientsRepository clientsRepository;

    public List<RentalsWithCostumeAndClient> getRentals() {
        return rentalsRepository.findBy();
    }

    public RentalsWithCostumeAndClient getRental(int id) {
        return rentalsRepository.findRentalById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
        );
    }

    public Rental insertRental(Rental rental, int clientId, int costumeId) {
        Client cl = clientsRepository.findById(rental.getClient().getId()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")
        );
        Costume co = costumesRepository.findById(rental.getCostume().getId()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Traje no encontrado")
        );
        cl.setRentals(null);
        co.setRentals(null);
        rental.setClient(cl);
        rental.setCostume(co);
        return rentalsRepository.save(rental);
    }

    public void deleteRental(int id) {
        rentalsRepository.deleteById(id);
    }
}
