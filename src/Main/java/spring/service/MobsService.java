package spring.service;


import org.springframework.stereotype.Service;
import spring.repository.MobsRepository;

@Service
public class MobsService {

    private final MobsRepository mobsRepository;

    public MobsService(MobsRepository mobsRepository) {
        this.mobsRepository = mobsRepository;
    }





}
