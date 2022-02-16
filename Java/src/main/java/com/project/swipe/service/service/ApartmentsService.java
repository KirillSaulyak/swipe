package com.project.swipe.service.service;

import com.project.swipe.model.Apartments;

import java.util.List;

public interface ApartmentsService {
    Apartments save(Apartments apartments);

    Apartments findById(Integer id);

    List<Apartments> findAll();

    void deleteById(Integer id);
}
