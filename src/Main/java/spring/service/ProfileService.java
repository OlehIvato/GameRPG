package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.Profile;
import spring.repository.ProfileRepository;
import spring.repository.ProfileRepository;


@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public Profile findOneById(Long id) {
        return profileRepository.getOne(id);
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }
}
