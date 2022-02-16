package com.project.swipe.service.service;

import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesFiles;

import java.util.List;

public interface ResidentialComplexesFilesService {
    ResidentialComplexesFiles save(ResidentialComplexesFiles residentialComplexesFiles);

    ResidentialComplexesFiles findById(Integer id);

    List<ResidentialComplexesFiles> findAll();

    List<ResidentialComplexesFiles> findByResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexes);

    void deleteById(Integer id);
}
