package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.model.Profile;
import spring.model.User;
import spring.model.User_Profile;
import spring.model.User_Roles;
import spring.repository.User_ProfileRepository;
import spring.repository.User_RolesRepository;
import spring.service.ProfileService;
import spring.service.UserService;

@Controller
@RequestMapping("account/")
public class AccountController {

    @Autowired
    UserService userService;
    @Autowired
    ProfileService profileService;
    @Autowired
    User_ProfileRepository user_profileRepository;
    @Autowired
    User_RolesRepository user_rolesRepository;


    @GetMapping("user/{id}")
    public String getUserInfo(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getOneById(id));
        return "account/profile";
    }

    @GetMapping("edit-info/{id}")
    public String openEditorInfo(Model model, @PathVariable("id") Long id) {
        Profile profile = profileService.findOneById(id);
        model.addAttribute("profile", profile);
        model.addAttribute("user", userService.getOneById(id));
        model.addAttribute("user_roles", user_rolesRepository.getOne(id));
        model.addAttribute("user_profile", user_profileRepository.getOne(id));
        return "account/edit-info";
    }


    @PostMapping("edit-info")
    public String saveInformationInfo(Profile profile, User user, User_Roles user_roles, User_Profile user_profile) {
        profileService.save(profile);
        userService.save(user);
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        return "redirect:/account/user/" + user.getId();
    }


    @GetMapping("edit-username/{id}")
    public String openEditorUsername(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getOneById(id));
        model.addAttribute("user_roles", user_rolesRepository.getOne(id));
        model.addAttribute("user_profile", user_profileRepository.getOne(id));
        return "account/edit-username";
    }

    @PostMapping("edit-username")
    public String saveNewUsername(User user, Model model, BindingResult bindingResult, User_Roles user_roles, User_Profile user_profile) {
        if (bindingResult.hasErrors()) {
            return "account/edit-username";
        }
        if (!userService.checkUsername(user)) {
            model.addAttribute("userError", "Someone already have that username");
            return "account/edit-username";
        }
        userService.save(user);
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        return "redirect:/account/user/" + user.getId();
    }


    @GetMapping("edit-password/{id}")
    public String openEditorPassword(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getOneById(id));
        model.addAttribute("user_roles", user_rolesRepository.getOne(id));
        model.addAttribute("user_profile", user_profileRepository.getOne(id));
        return "account/edit-password";
    }

    @PostMapping("edit-password")
    public String saveNewPassword(User user, Model model, BindingResult bindingResult, User_Roles user_roles, User_Profile user_profile) {
        if (bindingResult.hasErrors()) {
            return "account/edit-password";
        }
        if (!userService.editPassword(user)) {
            model.addAttribute("passwordError", "Passwords did't match or current password is incorrect");
            return "account/edit-password";
        }
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        return "redirect:/account/user/" + user.getId();
    }

    @GetMapping("edit-avatar/{id}")
    public String openEditorAvatar(Model model, @PathVariable("id") Long id) {
        model.addAttribute("profile", profileService.findOneById(id));
        model.addAttribute("user", userService.getOneById(id));
        return "account/edit-avatar";
    }

    @PostMapping("edit-avatar")
    public String saveAvatar(Profile profile, User user, @RequestParam("ava") MultipartFile file) {
        profileService.saveAvatar(profile, file);
        return "redirect:/account/user/" + user.getId();
    }

    @GetMapping("delete-avatar/{id}")
    public String deleteAvatar(User user, @PathVariable("id") Long id) {
        Profile profile = profileService.findOneById(id);
        profile.setAvatar(null);
        profileService.save(profile);
        return "redirect:/account/user/" + user.getId();
    }

}
