package spring.service;


import org.springframework.stereotype.Service;
import spring.repository.LocationRepository;

@Service
public class LocationService {

private final LocationRepository locationRepository;


    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


}
