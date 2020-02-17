package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.MobsModel;

import java.util.List;

@Repository
public interface MobsRepository extends JpaRepository <MobsModel, Long> {

    List<MobsModel> findAllByName(String name);
}
