package com.mapsa.controller;

import com.mapsa.dao.AccountDao;
import com.mapsa.dao.FlightDao;
import com.mapsa.model.Account;
import com.mapsa.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class PublicPageController {

   @Autowired
    private FlightDao flightDao;
   @Autowired
   private AccountDao accountDao;

    @RequestMapping("/")
    public String index(Model model){
        List<Flight> flights=flightDao.findAllFlight();
        model.addAttribute("flights",flights);
        model.addAttribute("account",new Account());
        System.out.println(model.getClass().getName());
        return "index";
    }

    @RequestMapping("/registering")
    public String registering(@ModelAttribute Account account){
        account.setActive("d");
        accountDao.addAccount(account);
        return "redirect:/";
    }
    @RequestMapping("/login")
    public String login(@ModelAttribute Account account,Model model){
        account=accountDao.checkLoginAccount(account);
        if(account !=null){
            List<Flight> flights=flightDao.findAllFlight();
            model.addAttribute("flights",flights);
        model.addAttribute("account",account);
            return "home";
        }
        return "redirect:/";
    }

}
