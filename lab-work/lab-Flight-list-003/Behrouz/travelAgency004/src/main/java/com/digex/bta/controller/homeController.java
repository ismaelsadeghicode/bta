package com.digex.bta.controller;

import com.digex.bta.model.flightDto;
import com.digex.bta.services.flightService;
import com.digex.bta.services.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class homeController {

    @Autowired
    private flightService flightService ;
    @Autowired
    private loginService loginService ;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";

    }
    @RequestMapping("/auth")
    public String auth(HttpServletRequest request){

        if ("admin".equalsIgnoreCase(request.getParameter("username")) &&
                "pass".equalsIgnoreCase(request.getParameter("password"))) {
            return "administrator" ; } else {
            return "login";

        }

    }

    @RequestMapping("/flights")
    public String getflights(Model model){
        List<flightDto> flights = flightService.getAllFlights() ;
        model.addAttribute("flights",flights);
        return "flights";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/registerUser")
    public String registerUser(HttpServletRequest request ,Model model){
        if (!request.getParameter("name").isEmpty() &&
        !request.getParameter("family").isEmpty() &&
        !request.getParameter("email").isEmpty() &&
        !request.getParameter("password").isEmpty()
        ) {
            model.addAttribute(request.getParameter("name")) ;
            return "index" ; } else {
        return "register";
    }


//    @RequestMapping("/flights")
//    public String products(Model model){
//        List<flightDto> flights = flightService.getAllFlights();
//        model.addAttribute("flights",flights);
//        return "flights";
//    }

}}
