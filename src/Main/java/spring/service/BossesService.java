package spring.service;



import org.springframework.stereotype.Service;
import spring.repository.BossesRepository;

@Service
public class BossesService {

    private final BossesRepository bossesRepository;

    public BossesService(BossesRepository bossesRepository) {
        this.bossesRepository = bossesRepository;
    }

}
