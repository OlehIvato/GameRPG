package spring.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.User;
import spring.model.User_Roles;
import spring.repository.RoleRepository;
import spring.repository.User_RolesRepository;
import spring.service.ProfileService;
import spring.service.UserService;

@Controller
@RequestMapping("admin/")
public class AdminController {

    private final UserService userService;
    private final ProfileService profileService;
    private final User_RolesRepository userRolesRepository;
    private final RoleRepository roleRepository;

    public AdminController(UserService userService, ProfileService profileService,
                           User_RolesRepository userRolesRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.profileService = profileService;
        this.userRolesRepository = userRolesRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("userlist")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "security/admin/users_list";
    }

    @GetMapping("userinfo/{id}")
    public String getAllInformation(@AuthenticationPrincipal User current, Model model, @PathVariable("id") Long id) {
        model.addAttribute("all_users_info", userService.getOneById(id));
        model.addAttribute("current", current.getId());
        return "security/admin/show_info";
    }

    @PostMapping("setrole")
    public String setRole(User_Roles userRoles) {
        userRolesRepository.save(userRoles);
        return "redirect:/admin/userlist";
    }

    @GetMapping("setrole/{id}")
    public String setRole(@PathVariable("id") Long user_id, Model model) {
        model.addAttribute("user_roles", userRolesRepository.getOne(user_id));
        User_Roles user_roles = userRolesRepository.getOne(user_id);
        model.addAttribute("role", roleRepository.getOne(user_roles.getRoles_id()));
        return "security/admin/set_role";
    }

    @GetMapping("removeuser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        profileService.deleteById(id);
        return "redirect:/admin/userlist";
    }

}