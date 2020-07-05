package spring.service;

import spring.model.EquipmentModel;

import java.util.List;


public interface EquipmentService {

    List<EquipmentModel> findAll();

    EquipmentModel findOneById(Long id);

    EquipmentModel save(EquipmentModel heroModel);

    void delete(Long id);

}

