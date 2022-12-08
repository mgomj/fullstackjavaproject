package com.elmolinar.elmolinar.costumes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.elmolinar.elmolinar.costumes.projections.CostumeWithRentals;
import com.elmolinar.elmolinar.costumes.projections.CostumeWithoutRentals;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CostumesService {
    private final CostumesRepository costumesRepository;

    public List<CostumeWithoutRentals> getCostumes() {
        return costumesRepository.findBy();
    }

    public List<CostumeWithoutRentals> getCostumesByName(String name) {
        return costumesRepository.findByNameContaining(name);
    }

    public CostumeWithRentals getCostume(int id) {
        return costumesRepository.findCostumeById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Traje no encontrado")
        );
    }

    public Costume insert(Costume c) {
        c.setId(0); 
        return costumesRepository.save(c);
    }

    public Costume update(Costume c, int id) {
        if(!costumesRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Traje no encontrado", null);
        }
        c.setId(id); 
        return costumesRepository.save(c);
    }

    public void delete(int id) {
        costumesRepository.deleteById(id);
    }
}
