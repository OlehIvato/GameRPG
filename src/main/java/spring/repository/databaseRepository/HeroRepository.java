package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import spring.model.databaseModel.HeroModel;

@Repository
public interface HeroRepository extends JpaRepository<HeroModel, Long> {
}

