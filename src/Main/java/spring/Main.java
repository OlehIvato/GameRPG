package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Main {

    @GetMapping("entry")
    public String help() {
        return "Entry";
    }

    @GetMapping("info")
    public String info() {
        return "AboutGame";
    }


}
