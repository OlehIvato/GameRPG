package spring.service;


import org.springframework.stereotype.Service;
import spring.model.LocationModel;
import spring.repository.HeroRepository;
import spring.repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

private final LocationRepository locationRepository;


    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public List<LocationModel> findAll() {
        return locationRepository.findAll();
    }

    public Optional<LocationModel> findOneById(Long id) {
        return locationRepository.findById(id);
    }

    public LocationModel save(LocationModel locationModel) {
        return locationRepository.save(locationModel);
    }

    public void delete(Long id) {
        locationRepository.deleteById(id);
    }

    public List<LocationModel> getName(String name) {
        return locationRepository.findAllByName(name);
    }

}
