package com.project.swipe.service.service;

import com.project.swipe.model.ResidentialComplexes;

import java.util.List;

public interface ResidentialComplexesService {
    ResidentialComplexes save(ResidentialComplexes residentialComplexes);

    ResidentialComplexes findById(Integer id);

    List<ResidentialComplexes> findAll();

    void deleteById(Integer id);
}
