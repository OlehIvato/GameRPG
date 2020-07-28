package spring.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.User;
import spring.service.imp.UserServiceImp;

@Controller
public class ForbiddenPageController {
    private static final Logger logger = Logger.getLogger(ForbiddenPageController.class.getName());

    @RequestMapping("/forbidden")
    public String accessDenied(@AuthenticationPrincipal User currentUser) {
        logger.error("User " + currentUser.getUsername() + " tried to get on forbidden page");
        return "security/forbiddenIndex";
    }


}

