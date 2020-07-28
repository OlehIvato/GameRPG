package spring.service;
import org.springframework.web.multipart.MultipartFile;
import spring.model.databaseModel.HeroModel;
import java.util.List;

public interface HeroService {

    List<HeroModel> findAll();

    HeroModel findOneById(Long id);

    void delete(Long id);

    HeroModel save(HeroModel heroModel);

    void saveWithImage(HeroModel hero, MultipartFile file);

}







