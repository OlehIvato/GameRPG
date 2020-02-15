package spring.service;

import org.springframework.stereotype.Service;
import spring.model.HeroModel;
import spring.repository.HeroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List <HeroModel> findAll() {
        return heroRepository.findAll();
    }

    public Optional <HeroModel> findOneById(Long id) {
        return heroRepository.findById(id);
    }

    public HeroModel save(HeroModel heroModel) {
        return heroRepository.save(heroModel);
    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    public List <HeroModel> getName(String name) {
        return heroRepository.findAllByName(name);
    }

    public List <HeroModel> readAllBy(String name) {
      List<HeroModel> heroModels = heroRepository.readAllBy("name");

        return heroModels;
    }
}
