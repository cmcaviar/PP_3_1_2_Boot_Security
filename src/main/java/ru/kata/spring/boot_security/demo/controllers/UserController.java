package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @GetMapping(value = "/")
//    public String getUserPage(ModelMap modelMap, Principal principal) {
//        modelMap.addAttribute("user", userService.loadUserByUsername(principal.getName()));
//        return "user";
//    }
@GetMapping("/{id}")
public String showUserPage(@PathVariable("id") int id, Model model) {
    model.addAttribute("user", userService.show(id));
    return "/user";

}
}
