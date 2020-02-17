package spring.service;


import org.springframework.stereotype.Service;
import spring.model.MobsModel;
import spring.repository.MobsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MobsService {

    private final MobsRepository mobsRepository;

    public MobsService(MobsRepository mobsRepository) {
        this.mobsRepository = mobsRepository;
    }


    public List<MobsModel> findAll() {
        return mobsRepository.findAll();
    }

    public Optional<MobsModel> findOneById(Long id) {
        return mobsRepository.findById(id);
    }

    public MobsModel save(MobsModel mobsModel) {
        return mobsRepository.save(mobsModel);
    }

    public void delete(Long id) {
        mobsRepository.deleteById(id);
    }

    public List<MobsModel> getName(String name) {
        return mobsRepository.findAllByName(name);
    }


}
