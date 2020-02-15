package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.model.HeroModel;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository <HeroModel, Long> {

    List <HeroModel> findAllByName(String name);

    List <HeroModel> readAllBy(String name);

HeroModel getAllBy
}