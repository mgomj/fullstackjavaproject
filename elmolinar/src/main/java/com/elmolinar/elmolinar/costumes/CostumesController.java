package com.elmolinar.elmolinar.costumes;

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

import com.elmolinar.elmolinar.costumes.projections.CostumeWithRentals;
import com.elmolinar.elmolinar.costumes.projections.CostumeWithoutRentals;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/costumes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CostumesController {
    private final CostumesService costumesService;

    @GetMapping
    public List<CostumeWithoutRentals> getCostumes() {
        return costumesService.getCostumes();
    }
    
    @GetMapping("/name")
    public List<CostumeWithoutRentals> getCostumes(@RequestParam(required = false) String name) {
        if(name != null) {
            return costumesService.getCostumesByName(name);
        } else {
            return costumesService.getCostumes();
        }
    }

    @GetMapping("/{id}")
    public CostumeWithRentals getCostume(@PathVariable int id) {
        return costumesService.getCostume(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Costume insertCostume(@RequestBody Costume c) {
        return costumesService.insert(c);
    }

    @PutMapping("/{id}")
    public Costume updateCostume(@RequestBody Costume c, @PathVariable int id) {
        return costumesService.update(c, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCostume(@PathVariable int id) {
        costumesService.delete(id);
    }
    
}
