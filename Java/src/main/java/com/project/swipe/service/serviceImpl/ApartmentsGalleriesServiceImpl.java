package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.ApartmentsGalleries;
import com.project.swipe.repository.ApartmentsGalleriesRepository;
import com.project.swipe.service.service.ApartmentsGalleriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentsGalleriesServiceImpl implements ApartmentsGalleriesService {
    @Autowired
    private ApartmentsGalleriesRepository apartmentsGalleriesRepository;

    @Override
    public ApartmentsGalleries save(ApartmentsGalleries apartmentsGalleries) {
        return apartmentsGalleriesRepository.save(apartmentsGalleries);
    }

    @Override
    public ApartmentsGalleries findById(Integer id) {
        Optional<ApartmentsGalleries> apartmentsGalleries = apartmentsGalleriesRepository.findById(id);
        if (!apartmentsGalleries.isEmpty()) {
            return apartmentsGalleries.get();
        }
        return null;
    }

    @Override
    public List<ApartmentsGalleries> findAll() {
        return apartmentsGalleriesRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        apartmentsGalleriesRepository.deleteById(id);
    }
}
