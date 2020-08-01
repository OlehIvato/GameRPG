package spring.service;

import org.springframework.web.multipart.MultipartFile;
import spring.model.Profile;

public interface ProfileService {

    Profile findOneByUsername(String username);

    Profile save(Profile profile);

    void saveAvatar(Profile profile, MultipartFile file);

}

