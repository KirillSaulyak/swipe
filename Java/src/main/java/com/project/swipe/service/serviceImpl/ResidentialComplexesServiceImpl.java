package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.repository.ResidentialComplexesRepository;
import com.project.swipe.service.service.ResidentialComplexesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentialComplexesServiceImpl implements ResidentialComplexesService {
    @Autowired
    private ResidentialComplexesRepository residentialComplexesRepository;

    @Override
    public ResidentialComplexes save(ResidentialComplexes residentialComplexes) {
        return residentialComplexesRepository.save(residentialComplexes);
    }

    @Override
    public ResidentialComplexes findById(Integer id) {
        Optional<ResidentialComplexes> residentialComplexes = residentialComplexesRepository.findById(id);
        if (!residentialComplexes.isEmpty()) {
            return residentialComplexes.get();
        }
        return null;
    }

    @Override
    public List<ResidentialComplexes> findAll() {
        return residentialComplexesRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        residentialComplexesRepository.deleteById(id);
    }
}
