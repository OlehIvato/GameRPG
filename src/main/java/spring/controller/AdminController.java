package spring.controller;

import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
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
import spring.service.UserService;

@Controller
@RequestMapping("admin/")
@PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final User_RolesRepository userRolesRepository;
    private final RoleRepository roleRepository;

    private static final Logger logger = Logger.getLogger(AdminController.class.getName());

    @GetMapping("user-list")
    public String userList(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        logger.info("User " + currentUser.getUsername() + " views information about all users");
        return "security/admin/users_list";
    }

    @GetMapping("user-info/{id}")
    public String getAllInformation(@AuthenticationPrincipal User current, Model model, @PathVariable("id") Long id) {
        model.addAttribute("all_users_info", userService.getOneById(id));
        model.addAttribute("current", current.getId());
        logger.info("User " + current.getUsername()
                + " views personal information about User "
                + userService.getOneById(id).getUsername());
        return "security/admin/show_info";
    }

    @GetMapping("set-role/{id}")
    public String setRole(@AuthenticationPrincipal User currentUser, @PathVariable("id") Long user_id, Model model) {
        User_Roles user_roles = userRolesRepository.getOne(user_id);
        model.addAttribute("user_roles", user_roles);
        model.addAttribute("role", roleRepository.getOne(user_roles.getRoles_id()));
        logger.info("User " + currentUser.getUsername()
                + " clicked on set role button for user "
                + userService.getOneById(user_id).getUsername());
        return "security/admin/set_role";
    }

    @PostMapping("set-role")
    public String setRole(User_Roles userRoles) {
        userRolesRepository.save(userRoles);
        return "redirect:/admin/user-list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("remove-user/{id}")
    public String deleteUser(@AuthenticationPrincipal User currentUser, @PathVariable("id") Long id) {
        String username = userService.getOneById(id).getUsername();
        User user = userService.getOneById(id);
        userService.deleteUser(user.getUsername(), id);
        logger.info("User: " + username + " has been totally deleted by " + currentUser.getUsername());
        return "redirect:/admin/user-list";
    }

}