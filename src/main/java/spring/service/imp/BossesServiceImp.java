package spring.service.imp;

import org.springframework.stereotype.Service;
import spring.model.databaseModel.BossesModel;

import spring.repository.databaseRepository.BossesRepository;
import spring.service.BossesService;

import java.util.List;

@Service
public class BossesServiceImp implements BossesService {

    private final BossesRepository bossesRepository;

    public BossesServiceImp(BossesRepository bossesRepository) {
        this.bossesRepository = bossesRepository;
    }

    @Override
    public List<BossesModel> findAll() {
        return bossesRepository.findAll();
    }

    @Override
    public BossesModel findOneById(Long id) {
        return bossesRepository.getOne(id);
    }

    @Override
    public BossesModel save(BossesModel heroModel) {
        return bossesRepository.save(heroModel);
    }

    @Override
    public void delete(Long id) {
        bossesRepository.deleteById(id);
    }
}


