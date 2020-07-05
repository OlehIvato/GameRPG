package spring.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.config.MvcConfig;
import spring.model.HeroModel;
import spring.repository.HeroRepository;
import spring.service.HeroService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class HeroServiceImp implements HeroService {

    private final HeroRepository heroRepository;

    public HeroServiceImp(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<HeroModel> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public HeroModel findOneById(Long id) {
        return heroRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    @Override
    public HeroModel save(HeroModel heroModel) {
        return heroRepository.save(heroModel);
    }

    @Override
    public void saveWithImage(HeroModel hero, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String getOriginalName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + getOriginalName;
            try {
                file.transferTo(new File(MvcConfig.pathHeroImage + fileName));
                hero.setImage(fileName);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        save(hero);
    }
}



