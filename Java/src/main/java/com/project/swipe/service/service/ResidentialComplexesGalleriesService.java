package com.project.swipe.service.service;

import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesGalleries;

import java.util.List;

public interface ResidentialComplexesGalleriesService {
    ResidentialComplexesGalleries save(ResidentialComplexesGalleries residentialComplexesGalleries);

    ResidentialComplexesGalleries findById(Integer id);

    List<ResidentialComplexesGalleries> findAll();

    List<ResidentialComplexesGalleries> findByResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexes);

    void deleteById(Integer id);

}
