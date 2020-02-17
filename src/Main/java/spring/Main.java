package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Main {

    @GetMapping("main")
    public String help() {
        return "main";
    }
}
