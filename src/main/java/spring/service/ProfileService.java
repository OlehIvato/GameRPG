package spring.service;

import org.springframework.web.multipart.MultipartFile;
import spring.model.Profile;

public interface ProfileService {

    Profile findOneById(Long id);

    Profile save(Profile profile);

    void deleteById(Long id);

    void saveAvatar(Profile profile, MultipartFile file);

}

