package spring.service.imp;

import org.springframework.stereotype.Service;
import spring.model.EquipmentModel;
import spring.repository.EquipmentRepository;
import spring.service.EquipmentService;

import java.util.List;

@Service
public class EquipmentServiceImp implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImp(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<EquipmentModel> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public EquipmentModel findOneById(Long id) {
        return equipmentRepository.getOne(id);
    }

    @Override
    public EquipmentModel save(EquipmentModel heroModel) {
        return equipmentRepository.save(heroModel);
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}


