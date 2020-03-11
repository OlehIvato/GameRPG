package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.model.User_Roles;
import spring.repository.User_RolesRepository;
import spring.service.UserService;

@Controller
public class AdminController {

    @Autowired
    private User_RolesRepository userRolesRepository;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "Security/admin";
    }

    @PostMapping("/admin")
    public String deleteUser(Long userId, String action) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/set_role/{user_id}")
    public String setRole(@PathVariable("user_id") Long user_id, Model model) {
        User_Roles userRoles = userRolesRepository.getOne(user_id);
        model.addAttribute("roles", userRoles);
        return "Security/set_role";
    }

    @PostMapping("/set_role")
    public String setRole(User_Roles userRoles) {
        userRolesRepository.save(userRoles);
        return "redirect:/admin";
    }
}