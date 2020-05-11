package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.User_Roles;
import spring.repository.User_RolesRepository;
import spring.service.UserService;

@Controller
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    private User_RolesRepository userRolesRepository;
    @Autowired
    private UserService userService;

    @GetMapping("users_list")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "security/admin/users_list";
    }


    @GetMapping("all_users_information/{id}")
    public String getAllInformation(Model model, @PathVariable("id") Long id) {
        model.addAttribute("all_users_info", userService.getOneById(id));
        return "security/admin/show_info";
    }


    @GetMapping("set_role/{user_id}")
    public String setRole(@PathVariable("user_id") Long user_id, Model model) {
        User_Roles userRoles = userRolesRepository.getOne(user_id);
        model.addAttribute("roles", userRoles);
        return "security/admin/set_role";
    }

    @PostMapping("set_role")
    public String setRole(User_Roles userRoles) {
        userRolesRepository.save(userRoles);
        return "redirect:/admin/users_list";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users_list";
    }

}