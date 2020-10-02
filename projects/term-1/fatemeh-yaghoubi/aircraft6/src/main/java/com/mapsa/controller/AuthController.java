package com.mapsa.controller;

import com.mapsa.dao.UserDao;

import com.mapsa.model.User;

import com.mapsa.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;


@Controller


public class
AuthController {


    @Autowired
    UserService userService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/loginCheck")
    public ModelAndView loginCheck(
            @RequestParam String username,
            @RequestParam String password,
            Model model

    ) {

        ModelAndView mv = new ModelAndView();
        User user = userService.getUserByUsername(username);


        if (user != null) {

            if (password.equals(user.getPassword())) {
                mv.setViewName("/dashboard");


            } else {

                mv.addObject("message", "پسورد درست نمی باشد.");
                mv.setViewName("login");

            }


        } else {

            mv.addObject("message", "یوزر پیدا نشد ");

            mv.setViewName("login");

        }


        return mv;

    }


}