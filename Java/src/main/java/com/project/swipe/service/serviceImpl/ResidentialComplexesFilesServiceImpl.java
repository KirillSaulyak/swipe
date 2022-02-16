package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesFiles;
import com.project.swipe.repository.ResidentialComplexesFilesRepository;
import com.project.swipe.service.service.ResidentialComplexesFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentialComplexesFilesServiceImpl implements ResidentialComplexesFilesService {
    @Autowired
    private ResidentialComplexesFilesRepository residentialComplexesFilesRepository;

    @Override
    public ResidentialComplexesFiles save(ResidentialComplexesFiles residentialComplexesFiles) {
        return residentialComplexesFilesRepository.save(residentialComplexesFiles);
    }

    @Override
    public ResidentialComplexesFiles findById(Integer id) {
        Optional<ResidentialComplexesFiles> residentialComplexesFiles = residentialComplexesFilesRepository.findById(id);
        if (!residentialComplexesFiles.isEmpty()) {
            return residentialComplexesFiles.get();
        }
        return null;
    }

    @Override
    public List<ResidentialComplexesFiles> findAll() {
        return residentialComplexesFilesRepository.findAll();
    }

    @Override
    public List<ResidentialComplexesFiles> findByResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexes) {
        return residentialComplexesFilesRepository.findByResidentialComplexesByIdResidentialComplex(residentialComplexes);
    }

    @Override
    public void deleteById(Integer id) {
        residentialComplexesFilesRepository.deleteById(id);
    }
}
