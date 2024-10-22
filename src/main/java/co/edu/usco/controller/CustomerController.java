package co.edu.usco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping({"home", "/"})
    public String home() {
        return "redirect:/events";
    }

    @GetMapping("403")
    public String accessDenied() {
        return "403";
    }
}
