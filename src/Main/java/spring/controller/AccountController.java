package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.Profile;
import spring.model.User;
import spring.model.User_Profile;
import spring.model.User_Roles;
import spring.repository.User_ProfileRepository;
import spring.repository.User_RolesRepository;
import spring.service.ProfileService;
import spring.service.UserService;

import java.security.Principal;


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

    @GetMapping("editinfo/{id}")
    public String openEditorInfo(Model model, @PathVariable("id") Long id) {
        Profile profile = profileService.findOneById(id);
        model.addAttribute("profile", profile);
        return "account/edit-personal-info";
    }

    @PostMapping("editinfo")
    public String saveInformationInfo(Profile profile, User user) {
        profileService.saveProfile(profile);
        System.out.println(user.getId() + " =================== user id");
        System.out.println(profile.getId() + " =================== profile id");
        System.out.println(user.getUsername() + " =================== username ");
        return "redirect:/account/user/" + user.getId() ;
    }

    @GetMapping("editsecurity/{id}")
    public String openEditorSecurity(Model model, @PathVariable("id") Long id) {
        User user = userService.getOneById(id);
        User_Roles user_roles = user_rolesRepository.getOne(id);
        User_Profile user_profile = user_profileRepository.getOne(id);
        model.addAttribute("user", user);
        model.addAttribute("user_roles", user_roles);
        model.addAttribute("user_profile", user_profile);
        return "account/edit-security";
    }

    @PostMapping("editsecurity")
    public String saveInformationSecurity(User user, User_Roles user_roles, User_Profile user_profile) {
        userService.updateUser(user);
        user_profileRepository.save(user_profile);
        user_rolesRepository.save(user_roles);
        System.out.println(user.getId() + " user id  --------- ============================");
        return "redirect:/account/user/" + user.getId();
    }


}
