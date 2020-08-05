package com.test.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.test.model.Person;
import com.test.services.LoginService;
import com.test.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginRegisterController {


    private final RegisterService registerService;
    private final LoginService loginService;

    public LoginRegisterController(RegisterService registerService, LoginService loginService) {
        this.registerService = registerService;
        this.loginService = loginService;
    }

    @RequestMapping("/registering")
    public String Registering(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
        registerService.addPeople(new Person(name, password, email.toLowerCase()));
        return "redirect:/";
    }

    @RequestMapping("/register")
    public String Register() {
        return "register";
    }



    @RequestMapping("/logging")
    public String logging(@RequestParam("username") String username, @RequestParam("password") String password,Model model) {
        if (!Person.checkEmail(username) || password.trim().isEmpty()) {
            return "redirect:/";
        } else if (loginService.isLogging(username, password)) {
            model.addAttribute("username",username);
            return "redirect:/flight";
        } else {
            return "redirect:/";
        }
    }
}
