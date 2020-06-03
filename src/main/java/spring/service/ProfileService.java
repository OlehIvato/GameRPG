package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.model.Profile;
import spring.repository.ProfileRepository;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Value("C:\\Users\\doc\\Desktop\\rpg MiniGame\\src\\main\\resources\\avatars\\")
    private String avatarPath;

    public Profile findOneById(Long id) {
        return profileRepository.getOne(id);
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }

    public void saveAvatar(Profile profile, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String getAvatarName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + getAvatarName;
            try {
                file.transferTo(new File(avatarPath + fileName));
                profile.setAvatar((fileName));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            save(profile);
        }
    }

}

