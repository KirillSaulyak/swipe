package com.project.swipe.controller;

import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesFiles;
import com.project.swipe.model.ResidentialComplexesGalleries;
import com.project.swipe.service.service.ResidentialComplexesFilesService;
import com.project.swipe.service.service.ResidentialComplexesGalleriesService;
import com.project.swipe.service.service.ResidentialComplexesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

@RestController
public class RestControllerResidentialComplexes {
    @Autowired
    private ResidentialComplexesService residentialComplexesService;
    @Autowired
    private ResidentialComplexesGalleriesService residentialComplexesGalleriesService;
    @Autowired
    private ResidentialComplexesFilesService residentialComplexesFilesService;
    @Autowired
    private FileManager fileManager;

    @GetMapping("/residential-complexes")
    public List<ResidentialComplexes> getResidentialComplexes() {
        List<ResidentialComplexes> residentialComplexes = residentialComplexesService.findAll();
        return residentialComplexes;
    }

    @GetMapping("/residential-complexes/{idResidentialComplexes}")
    public ResidentialComplexes getResidentialComplexesById(@PathVariable Integer idResidentialComplexes) {
        return residentialComplexesService.findById(idResidentialComplexes);
    }

    @PostMapping("/residential-complexes")
    public ResidentialComplexes postResidentialComplexes(@RequestBody ResidentialComplexes residentialComplexes) {

        return residentialComplexesService.save(residentialComplexes);
    }

    @PutMapping("residential-complexes/{idResidentialComplexes}") //id для поддержки однотипности rest запросов
    public ResidentialComplexes putResidentialComplexes(@RequestBody ResidentialComplexes residentialComplexes) {
        return residentialComplexesService.save(residentialComplexes);
    }

    @DeleteMapping("/residential-complexes/{idResidentialComplexes}")
    public String deleteResidentialComplexes(@PathVariable Integer idResidentialComplexes) {
        ResidentialComplexes residentialComplexes = residentialComplexesService.findById(idResidentialComplexes);
        Collection<ResidentialComplexesGalleries> residentialComplexesGalleries = residentialComplexesGalleriesService.findByResidentialComplexesByIdResidentialComplex(residentialComplexes);
        for (ResidentialComplexesGalleries apartmentGallery : residentialComplexesGalleries) {
            fileManager.deleteFile(Paths.get(apartmentGallery.getPathToImage()));
        }

        Collection<ResidentialComplexesFiles> residentialComplexesFiles = residentialComplexesFilesService.findByResidentialComplexesByIdResidentialComplex(residentialComplexes);
        for (ResidentialComplexesFiles residentialComplexFile : residentialComplexesFiles) {
            fileManager.deleteFile(Paths.get(residentialComplexFile.getPathToFile()));
        }
        residentialComplexesService.deleteById(residentialComplexes.getIdResidentialComplex());
        return "was deleted idResidentialComplex = " + idResidentialComplexes;
    }
}
