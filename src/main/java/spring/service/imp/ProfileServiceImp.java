package spring.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.config.MvcConfig;
import spring.model.Profile;
import spring.repository.ProfileRepository;
import spring.service.ProfileService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiceImp implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImp(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findOneById(Long id) {
        return profileRepository.getOne(id);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public void saveAvatar(Profile profile, MultipartFile file) {
        if (Optional.ofNullable(file).isPresent() && !file.isEmpty()) {
            String getAvatarName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + getAvatarName;
            try {
                file.transferTo(new File(MvcConfig.pathAvatars + fileName));
                profile.setAvatar((fileName));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            save(profile);
        }
    }
}
