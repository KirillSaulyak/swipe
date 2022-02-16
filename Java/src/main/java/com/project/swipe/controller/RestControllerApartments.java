package com.project.swipe.controller;

import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.Apartments;
import com.project.swipe.model.ApartmentsGalleries;
import com.project.swipe.service.service.ApartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

@RestController
public class RestControllerApartments {
    @Autowired
    private ApartmentsService apartmentsService;
    @Autowired
    private FileManager fileManager;

    @GetMapping("/apartments")
    public List<Apartments> getApartments() {
        return apartmentsService.findAll();
    }

    @GetMapping("/apartments/{idApartments}")
    public Apartments getPersonalAccountById(@PathVariable Integer idApartments) {
        return apartmentsService.findById(idApartments);
    }

    @PostMapping("/apartments")
    public Apartments postApartments(@RequestBody Apartments apartments) {

        return apartmentsService.save(apartments);
    }

    @PutMapping("/apartments/{idApartments}") //id для поддержки однотипности rest запросов
    public Apartments putApartments(@RequestBody Apartments apartments) {
        return apartmentsService.save(apartments);
    }

    @DeleteMapping("/apartments/{idApartments}")
    public String deleteApartments(@PathVariable Integer idApartments) {
        Apartments apartments = apartmentsService.findById(idApartments);
        Collection<ApartmentsGalleries> apartmentsGalleries = apartments.getApartmentsGalleriesByIdApartment();
        for (ApartmentsGalleries apartmentGallery : apartmentsGalleries) {
            fileManager.deleteFile(Paths.get(apartmentGallery.getPathToImage()));
        }
        apartmentsService.deleteById(apartments.getIdApartment());
        return "was deleted idApartment = " + idApartments;
    }
}
