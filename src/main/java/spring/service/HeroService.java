package spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.config.MvcConfig;
import spring.model.HeroModel;

import spring.repository.HeroRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class HeroService {

    @Value("C:\\Users\\doc\\Desktop\\rpg MiniGame\\src\\main\\resources\\heroImages\\")
    private String pathHeroImage;

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

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    public List<HeroModel> getName(String name) {
        return heroRepository.findAllByName(name);
    }

    public HeroModel save(HeroModel heroModel) {
        return heroRepository.save(heroModel);
    }

    public void saveWithImage(HeroModel hero, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String getOriginalName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + getOriginalName;
            try {
                file.transferTo(new File(pathHeroImage + fileName));
                hero.setImage(fileName);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        save(hero);
    }

}






