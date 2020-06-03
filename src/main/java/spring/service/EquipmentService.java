package spring.service;

import org.springframework.stereotype.Service;
import spring.model.EquipmentModel;
import spring.repository.EquipmentRepository;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public java.util.List<EquipmentModel> findAll() {
        return equipmentRepository.findAll();
    }

    public EquipmentModel findOneById(Long id) {
        return equipmentRepository.getOne(id);
    }

    public EquipmentModel save(EquipmentModel heroModel) {
        return equipmentRepository.save(heroModel);
    }

    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    public List<EquipmentModel> getName(String name) {
        return equipmentRepository.findAllByName(name);
    }

}

