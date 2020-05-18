package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.User_Roles;
import spring.repository.User_RolesRepository;
import spring.service.ProfileService;
import spring.service.UserService;


@Controller
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    private User_RolesRepository userRolesRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;

    @GetMapping("userlist")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "security/admin/users_list";
    }


    @GetMapping("userinfo/{id}")
    public String getAllInformation(Model model, @PathVariable("id") Long id) {
        model.addAttribute("all_users_info", userService.getOneById(id));
        return "security/admin/show_info";
    }


    @PostMapping("setrole")
    public String setRole(User_Roles userRoles) {
        userRolesRepository.save(userRoles);
        return "redirect:/admin/userlist";
    }

    @GetMapping("setrole/{id}")
    public String setRole(@PathVariable("id") Long user_id, Model model) {
        User_Roles userRoles = userRolesRepository.getOne(user_id);
        model.addAttribute("roles", userRoles);
        return "security/admin/set_role";
    }

    @GetMapping("removeuser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        profileService.deleteById(id);
        return "redirect:/admin/userlist";
    }

}