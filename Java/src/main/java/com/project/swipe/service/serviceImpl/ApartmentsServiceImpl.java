package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.Apartments;
import com.project.swipe.repository.ApartmentsRepository;
import com.project.swipe.service.service.ApartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentsServiceImpl implements ApartmentsService {
    @Autowired
    private ApartmentsRepository apartmentsRepository;

    @Override
    public Apartments save(Apartments apartments) {
        return apartmentsRepository.save(apartments);
    }

    @Override
    public Apartments findById(Integer id) {
        Optional<Apartments> apartments = apartmentsRepository.findById(id);
        if (!apartments.isEmpty()) {
            return apartments.get();
        }
        return null;
    }

    @Override
    public List<Apartments> findAll() {
        return apartmentsRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        apartmentsRepository.deleteById(id);
    }
}
