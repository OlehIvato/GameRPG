package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.EquipmentModel;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentModel, Long> {

    @Query(value = "select equipment.id, name, hp, damage, energy, energy_res, spell_damage, mana, mana_res, armor_id, type_id\n" +
            "from equipment where armor_id = ? and type_id = ? ", nativeQuery = true)
   List<EquipmentModel> findByArmorsAndTypes(int armors_id, int type_id);




}
