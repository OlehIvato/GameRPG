package spring.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.model.User;
import spring.service.imp.UserServiceImp;
import javax.validation.Valid;
import java.util.Optional;
import java.util.logging.Logger;

@Controller

public class LoginController {
    private final UserServiceImp userServiceImp;
    private String userEmailAddress;

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    public LoginController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }


    @GetMapping("/test")
    public String test(Model model) {

            model.addAttribute("error", "username or password is invalid.");
        return "security/login";
    }

    @GetMapping("/login")
    public String logIn(Model model, String error) {
        if (error != null)
            model.addAttribute("error", "username or password is invalid.");
        return "security/login";
    }

    @GetMapping("/log-out")
    public String logOut(@AuthenticationPrincipal User currentUser) {
        logger.info("User " + currentUser.getUsername() + " has successfully logout");
        return "redirect:/logout";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordGet(Model model) {
        model.addAttribute("userForm", new User());
        return "security/forgot_password";
    }

    @PostMapping("/forgot-password")
    public String forgotPasswordPost(Model model, @ModelAttribute("userForm") @Valid User user,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Please provide a valid email address");
            return "security/forgot_password";
        }
        if (Optional.ofNullable(userServiceImp.getOneByEmail(user.getEmail())).isEmpty()) {
            model.addAttribute("error", "Email not Found");
            return "security/forgot_password";
        }
        if (Optional.ofNullable(userServiceImp.getOneByEmail(user.getEmail()).getEmail())
                .equals(Optional.ofNullable(user.getEmail()))) {
            userEmailAddress = user.getEmail();
            return "redirect:/new-password";
        } else {
            model.addAttribute("error", "Something went wrong");
            return "security/forgot_password";
        }
    }

    @GetMapping("/new-password")
    public String createNewPasswordGet(Model model) {
        if (Optional.ofNullable(userEmailAddress).isEmpty()) {
            return "redirect:/forgot-password";
        }
        model.addAttribute("newPasswordForm", new User());
        return "security/new_password";
    }

    @PostMapping("/new-password")
    public String createNewPasswordPost(Model model, @ModelAttribute("newPasswordForm") @Valid User user,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Password must be over 6 characters.");
            return "security/new_password";
        }
        if (Optional.ofNullable(user.getPassword_new()).isPresent()
                && Optional.ofNullable(user.getPassword_confirm()).isPresent()) {
            user.setEmail(userEmailAddress);
            if (!userServiceImp.resetPassword(user)) {
                model.addAttribute("error", "Passwords do not match ");
                return "security/new_password";
            }
        }
        return "security/login";
    }

}
