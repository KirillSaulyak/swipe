package com.project.swipe.controller;

import com.project.swipe.fileManager.FileManager;
import com.project.swipe.fileManager.TypesFile;
import com.project.swipe.model.ApartmentsGalleries;
import com.project.swipe.service.service.ApartmentsGalleriesService;
import com.project.swipe.service.service.ApartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.List;

@RestController
public class RestControllerApartmentsGalleries {
    @Autowired
    private ApartmentsService apartmentsService;
    @Autowired
    private ApartmentsGalleriesService apartmentsGalleriesService;
    @Autowired
    private FileManager fileManager;

    @GetMapping("/apartments-galleries")
    public List<ApartmentsGalleries> getApartmentsGalleries() {
        return apartmentsGalleriesService.findAll();
    }

    @GetMapping("/apartments-galleries/{idApartmentsGalleries}")
    public ApartmentsGalleries getApartmentsById(@PathVariable Integer idApartmentsGalleries) {
        return apartmentsGalleriesService.findById(idApartmentsGalleries);
    }

    @PostMapping("/apartments-galleries")
    public ApartmentsGalleries postApartmentsGalleries(@RequestParam("idApartments") Integer idApartments,
                                                       @RequestParam(name = "photo") MultipartFile file) {
        ApartmentsGalleries apartmentsGalleries = new ApartmentsGalleries();
        apartmentsGalleries.setApartmentsByIdApartment(apartmentsService.findById(idApartments));
        apartmentsGalleries.setPathToImage(fileManager.uploadFile(TypesFile.IMAGE, file).toString());

        return apartmentsGalleriesService.save(apartmentsGalleries);
    }

    @PutMapping("apartments-galleries/{idApartmentsGalleries}")
    public ApartmentsGalleries putApartmentsGalleries(@PathVariable Integer idApartmentsGalleries,
                                                      @RequestParam(name = "photo") MultipartFile file) {
        ApartmentsGalleries apartmentsGalleries = apartmentsGalleriesService.findById(idApartmentsGalleries);
        fileManager.deleteFile(Paths.get(apartmentsGalleries.getPathToImage()));
        apartmentsGalleries.setPathToImage(fileManager.uploadFile(TypesFile.IMAGE, file).toString());

        return apartmentsGalleriesService.save(apartmentsGalleries);
    }

    @DeleteMapping("/apartments-galleries/{idApartmentsGalleries}")
    public String deleteApartmentsGalleries(@PathVariable Integer idApartmentsGalleries) {
        ApartmentsGalleries apartmentsGalleries = apartmentsGalleriesService.findById(idApartmentsGalleries);
        fileManager.deleteFile(Paths.get(apartmentsGalleries.getPathToImage()));
        apartmentsGalleriesService.deleteById(apartmentsGalleries.getIdApartmentGallery());
        return "was deleted idApartmentsGallery = " + idApartmentsGalleries;
    }
}
