package com.project.swipe.controller;

import com.project.swipe.fileManager.FileManager;
import com.project.swipe.fileManager.TypesFile;
import com.project.swipe.model.ResidentialComplexesGalleries;
import com.project.swipe.service.service.ResidentialComplexesGalleriesService;
import com.project.swipe.service.service.ResidentialComplexesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.List;

@RestController
public class RestControllerResidentialComplexesGalleries {
    @Autowired
    private ResidentialComplexesService residentialComplexesService;
    @Autowired
    private ResidentialComplexesGalleriesService residentialComplexesGalleriesService;
    @Autowired
    private FileManager fileManager;

    @GetMapping("residential-complexes-galleries")
    public List<ResidentialComplexesGalleries> getResidentialComplexesGalleries() {
        return residentialComplexesGalleriesService.findAll();
    }

    @GetMapping("residential-complexes-galleries/{idResidentialComplexesGalleries}")
    public ResidentialComplexesGalleries getResidentialComplexesById(@PathVariable Integer idResidentialComplexesGalleries) {
        return residentialComplexesGalleriesService.findById(idResidentialComplexesGalleries);
    }

    @PostMapping("/residential-complexes-galleries")
    public ResidentialComplexesGalleries postResidentialComplexesGalleries(@RequestParam("idResidentialComplex") Integer idResidentialComplex,
                                                                           @RequestParam(name = "image") MultipartFile file) {
        ResidentialComplexesGalleries residentialComplexesGalleries = new ResidentialComplexesGalleries();
        residentialComplexesGalleries.setResidentialComplexesByIdResidentialComplex(residentialComplexesService.findById(idResidentialComplex));
        residentialComplexesGalleries.setPathToImage(fileManager.uploadFile(TypesFile.IMAGE, file).toString());

        return residentialComplexesGalleriesService.save(residentialComplexesGalleries);
    }

    @PutMapping("residential-complexes-galleries/{idResidentialComplexesGalleries}")
    public ResidentialComplexesGalleries putResidentialComplexesGalleries(@PathVariable Integer idResidentialComplexesGalleries,
                                                                          @RequestParam(name = "image") MultipartFile file) {
        ResidentialComplexesGalleries residentialComplexesGalleries = residentialComplexesGalleriesService.findById(idResidentialComplexesGalleries);
        fileManager.deleteFile(Paths.get(residentialComplexesGalleries.getPathToImage()));
        residentialComplexesGalleries.setPathToImage(fileManager.uploadFile(TypesFile.IMAGE, file).toString());

        return residentialComplexesGalleriesService.save(residentialComplexesGalleries);
    }

    @DeleteMapping("/residential-complexes-galleries/{idResidentialComplexesGalleries}")
    public String deleteResidentialComplexesGalleries(@PathVariable Integer idResidentialComplexesGalleries) {
        ResidentialComplexesGalleries residentialComplexesGalleries = residentialComplexesGalleriesService.findById(idResidentialComplexesGalleries);
        fileManager.deleteFile(Paths.get(residentialComplexesGalleries.getPathToImage()));
        residentialComplexesGalleriesService.deleteById(residentialComplexesGalleries.getIdResidentialComplexGallery());
        return "was deleted idResidentialComplexGallery = " + idResidentialComplexesGalleries;
    }
}
