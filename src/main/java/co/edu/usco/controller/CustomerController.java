package co.edu.usco.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    // TODO: Create all views
    @GetMapping("hello")
    public String hello() {
        return "Hello World SECURED";
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @PostMapping("new")
    public String newCustomer() {
        return "new";
    }

    @PutMapping("edit/{id}")
    public String editCustomer(@PathVariable Integer id) {
        return "edit: " + id;
    }

    @DeleteMapping("delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return "delete: " + id;
    }

    @GetMapping("403")
    public String accessDenied() {
        return "403";
    }
}
