package com.elmolinar.elmolinar.rentals;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

import com.elmolinar.elmolinar.rentals.projections.RentalsWithCostumeAndClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RentalsController {
    private final RentalsService rentalsService;
    private final RentalsPdfGeneratorService pdfGeneratorService;

    @GetMapping
    public List<RentalsWithCostumeAndClient> getRentals() {
        return rentalsService.getRentals();
    }

    @GetMapping("/{id}")
    public RentalsWithCostumeAndClient getRental(@PathVariable int id) {
        return rentalsService.getRental(id);
    }

    @PostMapping()
    public Rental insertRental(@RequestBody Rental rental) {
        return rentalsService.insertRental(rental, rental.getClient().getId(), rental.getCostume().getId());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRental(@PathVariable int id) {
        rentalsService.deleteRental(id);
    }

    @GetMapping("/{id}/pdf")
    public void generatePdf(HttpServletResponse response, @PathVariable int id) throws DocumentException, IOException{
        RentalsWithCostumeAndClient rental = rentalsService.getRental(id);
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat ("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=contrato" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export(response, rental);
    }
}

