package com.project.swipe.service.service;

import com.project.swipe.model.ApartmentsGalleries;

import java.util.List;

public interface ApartmentsGalleriesService {
    ApartmentsGalleries save(ApartmentsGalleries apartmentsGalleries);

    ApartmentsGalleries findById(Integer id);

    List<ApartmentsGalleries> findAll();

    void deleteById(Integer id);
}
