package com.elmolinar.elmolinar.clients;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elmolinar.elmolinar.clients.projections.ClientWithRentals;
import com.elmolinar.elmolinar.clients.projections.ClientWithoutRentals;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClientsController {
    private final ClientsService clientsService;

    @GetMapping
    public List<ClientWithoutRentals> getClients() {
        return clientsService.getClients();
    }

    @GetMapping("/name")
    public List<ClientWithoutRentals> getClients(@RequestParam(required = false) String name) {
        if(name != null) {
            return clientsService.getClientsByName(name);
        } else {
            return clientsService.getClients();
        }
    }

    @GetMapping("/{id}")
    public ClientWithRentals getClient(@PathVariable int id) {
        return clientsService.getClient(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody Client c) {
        return clientsService.insert(c);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client c, @PathVariable int id) {
        return clientsService.update(c, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable int id) {
        clientsService.delete(id);
    }
    
}
