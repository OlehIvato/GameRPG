package spring.service.imp;

import org.springframework.stereotype.Service;
import spring.model.MobsModel;
import spring.repository.MobsRepository;
import spring.service.MobsService;

import java.util.List;

@Service
public class MobsServiceImp implements MobsService {

    private final MobsRepository mobsRepository;

    public MobsServiceImp(MobsRepository mobsRepository) {
        this.mobsRepository = mobsRepository;
    }

    @Override
    public List<MobsModel> findAll() {
        return mobsRepository.findAll();
    }

    @Override
    public MobsModel findOneById(Long id) {
        return mobsRepository.getOne(id);
    }

    @Override
    public MobsModel save(MobsModel heroModel) {
        return mobsRepository.save(heroModel);
    }

    @Override
    public void delete(Long id) {
        mobsRepository.deleteById(id);
    }
}
