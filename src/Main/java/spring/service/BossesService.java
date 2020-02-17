package spring.service;


import org.springframework.stereotype.Service;
import spring.model.BossesModel;
import spring.repository.BossesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BossesService {

    private final BossesRepository bossesRepository;

    public BossesService(BossesRepository bossesRepository) {
        this.bossesRepository = bossesRepository;
    }


    public List<BossesModel> findAll() {
        return bossesRepository.findAll();
    }

    public Optional<BossesModel> findOneById(Long id) {
        return bossesRepository.findById(id);
    }

    public BossesModel save(BossesModel bossesModel) {
        return bossesRepository.save(bossesModel);
    }

    public void delete(Long id) {
        bossesRepository.deleteById(id);
    }

    public List<BossesModel> getName(String name) {
        return bossesRepository.findAllByName(name);
    }
}
