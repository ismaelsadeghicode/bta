package com.mapsa.controller;

import com.mapsa.model.Account;
import com.mapsa.service.AccountService;
import com.mapsa.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PublicPageController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    FlightService flightService;
    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    public String index(Model model, HttpSession httpSession) {
        httpSession.removeAttribute("accountId");
        httpSession.removeAttribute("personList");
        model.addAttribute("flights", flightService.flightList());
        model.addAttribute("account", accountService.getNewAccount());
        return "index";
    }

    @RequestMapping("/registering")
    public String registering(@ModelAttribute Account account) {
        accountService.addAccount(account);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute Account account, Model model) {
        account = accountService.checkLoginAccount(account);
        if (account != null) {
            model.addAttribute("flights", flightService.flightList());
            model.addAttribute("account", account);
            httpSession.setAttribute("accountId", account.getId());
            return "home";
        }
        return "redirect:/";
    }

}
