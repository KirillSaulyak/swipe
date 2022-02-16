package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesGalleries;
import com.project.swipe.repository.ResidentialComplexesGalleriesRepository;
import com.project.swipe.service.service.ResidentialComplexesGalleriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentialComplexesGalleriesServiceImpl implements ResidentialComplexesGalleriesService {
    @Autowired
    private ResidentialComplexesGalleriesRepository residentialComplexesGalleriesRepository;

    @Override
    public ResidentialComplexesGalleries save(ResidentialComplexesGalleries residentialComplexesGalleries) {
        return residentialComplexesGalleriesRepository.save(residentialComplexesGalleries);
    }

    @Override
    public ResidentialComplexesGalleries findById(Integer id) {
        Optional<ResidentialComplexesGalleries> residentialComplexesGalleries = residentialComplexesGalleriesRepository.findById(id);
        if (!residentialComplexesGalleries.isEmpty()) {
            return residentialComplexesGalleries.get();
        }
        return null;
    }

    @Override
    public List<ResidentialComplexesGalleries> findAll() {
        return residentialComplexesGalleriesRepository.findAll();
    }

    @Override
    public List<ResidentialComplexesGalleries> findByResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexes) {
        return residentialComplexesGalleriesRepository.findByResidentialComplexesByIdResidentialComplex(residentialComplexes);
    }

    @Override
    public void deleteById(Integer id) {
        residentialComplexesGalleriesRepository.deleteById(id);
    }
}
