package com.project.swipe.controller;

import com.project.swipe.fileManager.FileManager;
import com.project.swipe.fileManager.TypesFile;
import com.project.swipe.model.ResidentialComplexesFiles;
import com.project.swipe.service.service.ResidentialComplexesFilesService;
import com.project.swipe.service.service.ResidentialComplexesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.List;

@RestController
public class RestControllerResidentialComplexesFiles {
    @Autowired
    private ResidentialComplexesService residentialComplexesService;
    @Autowired
    private ResidentialComplexesFilesService residentialComplexesFilesService;
    @Autowired
    private FileManager fileManager;


    @GetMapping("residential-complexes-files")
    public List<ResidentialComplexesFiles> getResidentialComplexesFiles() {
        return residentialComplexesFilesService.findAll();
    }

    @GetMapping("residential-complexes-files/{idResidentialComplexesFiles}")
    public ResidentialComplexesFiles getPersonalAccountById(@PathVariable Integer idResidentialComplexesFiles) {
        return residentialComplexesFilesService.findById(idResidentialComplexesFiles);
    }

    @PostMapping("/residential-complexes-files")
    public ResidentialComplexesFiles postResidentialComplexesFiles(@RequestParam("idResidentialComplex") Integer idResidentialComplex,
                                                                   @RequestParam(name = "file") MultipartFile file) {
        ResidentialComplexesFiles residentialComplexesFiles = new ResidentialComplexesFiles();
        residentialComplexesFiles.setResidentialComplexesByIdResidentialComplex(residentialComplexesService.findById(idResidentialComplex));
        residentialComplexesFiles.setPathToFile(fileManager.uploadFile(TypesFile.FILE, file).toString());

        return residentialComplexesFilesService.save(residentialComplexesFiles);
    }

    @PutMapping("residential-complexes-files/{idResidentialComplexesFiles}")
    public ResidentialComplexesFiles putResidentialComplexesFiles(@PathVariable Integer idResidentialComplexesFiles,
                                                                  @RequestParam(name = "file") MultipartFile file) {
        ResidentialComplexesFiles residentialComplexesFiles = residentialComplexesFilesService.findById(idResidentialComplexesFiles);
        fileManager.deleteFile(Paths.get(residentialComplexesFiles.getPathToFile()));
        residentialComplexesFiles.setPathToFile(fileManager.uploadFile(TypesFile.FILE, file).toString());

        return residentialComplexesFilesService.save(residentialComplexesFiles);
    }

    @DeleteMapping("/residential-complexes-files/{idResidentialComplexesFiles}")
    public String deleteResidentialComplexesFiles(@PathVariable Integer idResidentialComplexesFiles) {
        ResidentialComplexesFiles residentialComplexesFiles = residentialComplexesFilesService.findById(idResidentialComplexesFiles);
        fileManager.deleteFile(Paths.get(residentialComplexesFiles.getPathToFile()));
        residentialComplexesFilesService.deleteById(residentialComplexesFiles.getIdResidentialComplexFile());
        return "was deleted idResidentialComplexFile = " + idResidentialComplexesFiles;
    }
}
