package spring.service;

import spring.model.databaseModel.EquipmentModel;
import spring.model.databaseModel.Type;

import java.util.List;

public interface EquipmentService {

    List<EquipmentModel> findAll();

    EquipmentModel findOneById(Long id);

    EquipmentModel save(EquipmentModel heroModel);

    void delete(Long id);

    List<EquipmentModel> findByArmorsAndTypes(int armors_id, int type_id );

}

