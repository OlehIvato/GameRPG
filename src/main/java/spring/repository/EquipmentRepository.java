package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.model.EquipmentModel;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentModel, Long> {

    @Query(value = "select equipment.id, name, hp, damage, energy, energy_res, spell_damage, mana, mana_res, " +
            "equipment_armors.armors_id, equipment_types.types_id\n" +
            "from equipment\n" +
            "inner join equipment_armors on equipment.id = equipment_armors.equipment_model_id\n" +
            "inner join equipment_types on equipment.id = equipment_types.equipment_model_id\n" +
            "where armors_id = ? and types_id = ?", nativeQuery = true)
   List<EquipmentModel> findByArmorsAndTypes(int armors_id, int type_id);




}
