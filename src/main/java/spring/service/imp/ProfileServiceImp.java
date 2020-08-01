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
    public Profile findOneByUsername(String username) {
        return profileRepository.findByUsername(username);
    }

    @Override
    public Profile save(Profile profile) {
      Profile profileDatabase = profileRepository.findByUsername(profile.getUsername());

        if (Optional.ofNullable(profile.getId()).isEmpty()) {
            profile.setId(profileDatabase.getId());
        }
        if (Optional.ofNullable(profile.getName()).isEmpty()) {
            profile.setName(profileDatabase.getName());
        }
        if (Optional.ofNullable(profile.getSurname()).isEmpty()) {
            profile.setSurname(profileDatabase.getSurname());
        }
        if (Optional.ofNullable(profile.getBirthday()).isEmpty()) {
            profile.setBirthday(profileDatabase.getBirthday());
        }
        if (Optional.ofNullable(profile.getGender()).isEmpty()) {
            profile.setGender(profileDatabase.getGender());
        }
        if (Optional.ofNullable(profile.getPhone()).isEmpty()) {
            profile.setPhone(profileDatabase.getPhone());
        }
        if (Optional.ofNullable(profile.getCountry()).isEmpty()) {
            profile.setCountry(profileDatabase.getCountry());
        }
        if (Optional.ofNullable(profile.getCity()).isEmpty()) {
            profile.setCity(profileDatabase.getCity());
        }
        if (Optional.ofNullable(profile.getZip()).isEmpty()) {
            profile.setZip(profileDatabase.getZip());
        }
        if (Optional.ofNullable(profile.getBio()).isEmpty()) {
            profile.setBio(profileDatabase.getBio());
        }
        if (Optional.ofNullable(profile.getAvatar()).isEmpty()) {
            profile.setAvatar(profileDatabase.getAvatar());
        }
        profile.setUser(profileDatabase.getUser());
        return profileRepository.save(profile);
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
