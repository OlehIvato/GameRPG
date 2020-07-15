package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForbiddenPageController {

    @RequestMapping("/forbidden")
    public String accessDenied() {
        return "security/forbiddenIndex";
    }


}

