package spring.service;


import org.springframework.stereotype.Service;
import spring.model.MobsModel;
import spring.repository.MobsRepository;

import java.util.List;

@Service
public class MobsService {

    private final MobsRepository mobsRepository;

    public MobsService(MobsRepository mobsRepository) {
        this.mobsRepository = mobsRepository;
    }


    public List<MobsModel> findAll() {
        return mobsRepository.findAll();
    }

    public MobsModel findOneById(Long id) {
        return mobsRepository.getOne(id);
    }

    public MobsModel save(MobsModel heroModel) {
        return mobsRepository.save(heroModel);
    }

    public void delete(Long id) {
        mobsRepository.deleteById(id);
    }

    public List<MobsModel> getName(String name) {
        return mobsRepository.findAllByName(name);
    }


}
