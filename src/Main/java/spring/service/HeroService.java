package spring.service;


import org.springframework.stereotype.Service;
import spring.model.HeroModel;
import spring.repository.HeroRepository;
import java.util.List;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<HeroModel> findAll() {
        return heroRepository.findAll();
    }

    public HeroModel findOneById(Long id) {
        return heroRepository.getOne(id);
    }

    public HeroModel save(HeroModel heroModel) {
        return heroRepository.save(heroModel);
    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    public List<HeroModel> getName(String name) {
        return heroRepository.findAllByName(name);
    }

}
