package spring.controller;

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
import spring.model.Profile;
import spring.model.User;
import spring.model.User_Profile;
import spring.model.User_Roles;
import spring.repository.User_ProfileRepository;
import spring.repository.User_RolesRepository;
import spring.service.ProfileService;
import spring.service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping("account/")
@PreAuthorize("hasAnyRole('USER','MODERATOR')")
public class AccountController {

    private final UserService userService;
    private final ProfileService profileService;
    private final User_ProfileRepository user_profileRepository;
    private final User_RolesRepository user_rolesRepository;

    public AccountController(UserService userService, ProfileService profileService,
                             User_ProfileRepository user_profileRepository, User_RolesRepository user_rolesRepository) {
        this.userService = userService;
        this.profileService = profileService;
        this.user_profileRepository = user_profileRepository;
        this.user_rolesRepository = user_rolesRepository;
    }

    @GetMapping("user")
    public String getUserInfo(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user", userService.getOneById(currentUser.getId()));
        model.addAttribute("currentUser", currentUser.getId());
        return "account/profile";
    }

    @GetMapping("edit-info")
    public String openEditorInfo(@AuthenticationPrincipal User currentUser, Model model) {
        Profile profile = profileService.findOneById(currentUser.getId());
        model.addAttribute("profile", profile);
        model.addAttribute("user", userService.getOneById(currentUser.getId()));
        model.addAttribute("user_roles", user_rolesRepository.getOne(currentUser.getId()));
        model.addAttribute("user_profile", user_profileRepository.getOne(currentUser.getId()));
        return "account/edit-info";
    }

    @PostMapping("edit-info")
    public String saveInformationInfo(User user, Profile profile, User_Roles user_roles, User_Profile user_profile) {
        profileService.save(profile);
        userService.save(user);
        user_rolesRepository.save(user_roles);
        user_profileRepository.save(user_profile);
        return "redirect:/account/user";
    }

    @GetMapping("edit-username")
    public String openEditorUsername(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user", userService.getOneById(currentUser.getId()));
        model.addAttribute("user_roles", user_rolesRepository.getOne(currentUser.getId()));
        model.addAttribute("user_profile", user_profileRepository.getOne(currentUser.getId()));
        return "account/edit-username";
    }

    @PostMapping("edit-username")
    public String saveNewUsername(User user, Model model, BindingResult bindingResult, User_Roles user_roles,
                                  User_Profile user_profile) {
        if (bindingResult.hasErrors()) {
            return "account/edit-username";
        }
        if (!userService.updateUsername(user)) {
            model.addAttribute("userError", "Someone already have that username");
            return "account/edit-username";
        }
        userService.save(user);
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        return "redirect:/account/user";
    }

    @GetMapping("edit-password")
    public String openEditorPassword(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user", userService.getOneById(currentUser.getId()));
        model.addAttribute("user_roles", user_rolesRepository.getOne(currentUser.getId()));
        model.addAttribute("user_profile", user_profileRepository.getOne(currentUser.getId()));
        return "account/edit-password";
    }

    @PostMapping("edit-password")
    public String saveNewPassword(User user, Model model, BindingResult bindingResult, User_Roles user_roles,
                                  User_Profile user_profile) {
        if (bindingResult.hasErrors()) {
            return "account/edit-password";
        }
        if (!userService.updatePassword(user)) {
            model.addAttribute("passwordError", "Passwords did't match or current password is incorrect");
            return "account/edit-password";
        }
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        return "redirect:/account/user";
    }

    @GetMapping("edit-avatar")
    public String openEditorAvatar(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("profile", profileService.findOneById(currentUser.getId()));
        model.addAttribute("user", userService.getOneById(currentUser.getId()));
        return "account/edit-avatar";
    }

    @PostMapping("edit-avatar")
    public String saveAvatar(Profile profile, @RequestParam("ava") MultipartFile file) {
        profileService.saveAvatar(profile, file);
        return "redirect:/account/user";
    }

    @GetMapping("delete-avatar")
    public String deleteAvatar(@AuthenticationPrincipal User currentUser) {
        Profile profile = profileService.findOneById(currentUser.getId());
        Path path = Path.of(MvcConfig.pathAvatars + profile.getAvatar());
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.out.println("No such file");
            e.printStackTrace();
        }
        profile.setAvatar(null);
        profileService.save(profile);
        return "redirect:/account/user";
    }

}
