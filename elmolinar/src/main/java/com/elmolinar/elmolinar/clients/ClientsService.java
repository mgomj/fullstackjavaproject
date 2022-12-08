package com.elmolinar.elmolinar.clients;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.elmolinar.elmolinar.clients.projections.ClientWithRentals;
import com.elmolinar.elmolinar.clients.projections.ClientWithoutRentals;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientsService {
    private final ClientsRepository clientsRepository;

    public List<ClientWithoutRentals> getClients() {
        return clientsRepository.findBy();
    }

    public List<ClientWithoutRentals> getClientsByName(String name) {
        // return catRepository.getByName("%" + name + "%");
        return clientsRepository.findByNameContaining(name);
    }

    public ClientWithRentals getClient(int id) {
        return clientsRepository.findClientById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrada")
        );
    }

    public Client insert(Client c) {
        c.setId(0); 
        return clientsRepository.save(c);
    }

    public Client update(Client c, int id) {
        if(!clientsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado", null);
        }
        c.setId(id); 
        return clientsRepository.save(c);
    }

    public void delete(int id) {
        clientsRepository.deleteById(id);
    }
}
