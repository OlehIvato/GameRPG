package spring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.databaseModel.LocationModel;
import spring.repository.databaseRepository.LocationRepository;
import spring.service.LocationService;

import java.util.List;

@Service
public class LocationServiceImp implements LocationService {

    @Autowired
    private  LocationRepository locationRepository;


    public LocationServiceImp(){

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

