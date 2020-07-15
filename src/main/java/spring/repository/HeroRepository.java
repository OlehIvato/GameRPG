package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import spring.model.Armor;
import spring.model.HeroModel;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.List;
import java.util.Set;

@Repository
public interface HeroRepository extends JpaRepository<HeroModel, Long> {
}

