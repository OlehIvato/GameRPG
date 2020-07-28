package spring.controller;

import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spring.config.MvcConfig;
import spring.dto.User_ProfileDto;
import spring.model.Profile;
import spring.model.User;
import spring.model.User_Profile;
import spring.model.User_Roles;
import spring.repository.User_ProfileRepository;
import spring.repository.User_RolesRepository;
import spring.service.ProfileService;
import spring.service.UserService;
import spring.service.imp.ProfileServiceImp;
import spring.service.imp.UserServiceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Controller
@RequestMapping("account/")
@PreAuthorize("hasAnyRole('USER','MODERATOR')")
@AllArgsConstructor
public class AccountController {


    private final ProfileServiceImp profileServiceImp;
    private final User_ProfileRepository user_profileRepository;
    private final User_RolesRepository user_rolesRepository;
    private final UserServiceImp userServiceImp;


    private static final Logger logger = Logger.getLogger(AccountController.class.getName());

    @GetMapping("user")
    public String getUserInfo(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user_profile",
                new User_ProfileDto(
                        userServiceImp.getOneById(currentUser.getId()),
                        profileServiceImp.findOneById(currentUser.getId())));
        return "account/profile";
    }

    @GetMapping("edit-info")
    public String openEditorInfo(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user_profile",
                new User_ProfileDto(
                        userServiceImp.getOneById(currentUser.getId()),
                        profileServiceImp.findOneById(currentUser.getId()),
                        user_rolesRepository.getOne(currentUser.getId()),
                        user_profileRepository.getOne(currentUser.getId())));

        return "account/edit-info";
    }

    @PostMapping("edit-info")
    public String saveInformationInfo(User user, Profile profile, User_Roles user_roles, User_Profile user_profile) {
        profileServiceImp.save(profile);
        userServiceImp.save(user);
        user_rolesRepository.save(user_roles);
        user_profileRepository.save(user_profile);
        logger.info("User: " + user.getUsername() + " updated his personal information");
        return "redirect:/account/user";
    }

    @GetMapping("edit-username")
    public String openEditorUsername(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user_profile",
                new User_ProfileDto(
                        userServiceImp.getOneById(currentUser.getId()),
                        user_rolesRepository.getOne(currentUser.getId()),
                        user_profileRepository.getOne(currentUser.getId())));
        return "account/edit-username";
    }

    @PostMapping("edit-username")
    public String saveNewUsername(User user, Model model, BindingResult bindingResult, User_Roles user_roles,
                                  User_Profile user_profile) {
        if (bindingResult.hasErrors()) {
            return "account/edit-username";
        }
        if (!userServiceImp.updateUsername(user)) {
            model.addAttribute("userError", "Someone already have that username");
            return "account/edit-username";
        }
        userServiceImp.save(user);
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        logger.info("User " + user.getUsername() + " changed his username");
        return "redirect:/account/user";
    }

    @GetMapping("edit-password")
    public String openEditorPassword(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user_profile",
                new User_ProfileDto(
                        userServiceImp.getOneById(currentUser.getId()),
                        user_rolesRepository.getOne(currentUser.getId()),
                        user_profileRepository.getOne(currentUser.getId())));
        return "account/edit-password";
    }

    @PostMapping("edit-password")
    public String saveNewPassword(User user, Model model, BindingResult bindingResult, User_Roles user_roles,
                                  User_Profile user_profile) {
        if (bindingResult.hasErrors()) {
            return "account/edit-password";
        }
        if (!userServiceImp.updatePassword(user)) {
            model.addAttribute("passwordError", "Passwords did't match or current password is incorrect");
            return "account/edit-password";
        }
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        return "redirect:/account/user";
    }

    @GetMapping("edit-avatar")
    public String openEditorAvatar(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user_profile",
                new User_ProfileDto(
                        userServiceImp.getOneById(currentUser.getId()),
                        profileServiceImp.findOneById(currentUser.getId())));
        return "account/edit-avatar";
    }

    @PostMapping("edit-avatar")
    public String saveAvatar(@AuthenticationPrincipal User currentUser,
                             Profile profile,
                             @RequestParam("ava") MultipartFile file) {
        profileServiceImp.saveAvatar(profile, file);
        logger.info("User: " + currentUser.getUsername() + " updated his avatar");
        return "redirect:/account/user";
    }

    @GetMapping("delete-avatar")
    public String deleteAvatar(@AuthenticationPrincipal User currentUser) {
        Profile profile = profileServiceImp.findOneById(currentUser.getId());
        Path path = Path.of(MvcConfig.pathAvatars + profile.getAvatar());
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.out.println("No such file");
            e.printStackTrace();
        }
        profile.setAvatar(null);
        profileServiceImp.save(profile);
        logger.info("User: " + currentUser.getUsername() + " deleted his avatar");
        return "redirect:/account/user";
    }

}
