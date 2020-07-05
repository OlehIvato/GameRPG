package spring.service.imp;

import org.springframework.stereotype.Service;
import spring.model.LocationModel;
import spring.repository.LocationRepository;
import spring.service.LocationService;

import java.util.List;

@Service
public class LocationServiceImp implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImp(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationModel> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public LocationModel findOneById(Long id) {
        return locationRepository.getOne(id);
    }

    @Override
    public LocationModel save(LocationModel heroModel) {
        return locationRepository.save(heroModel);
    }

    @Override
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}

