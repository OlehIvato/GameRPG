package spring.service;
import spring.model.databaseModel.LocationModel;

import java.util.List;

public interface LocationService {

    List<LocationModel> findAll();

    LocationModel findOneById(Long id);

    LocationModel save(LocationModel heroModel);

    void delete(Long id);

}
