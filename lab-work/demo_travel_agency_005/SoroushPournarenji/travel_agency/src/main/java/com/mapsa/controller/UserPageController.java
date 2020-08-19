package com.mapsa.controller;

import com.mapsa.dao.AccountDao;
import com.mapsa.dao.FlightDao;
import com.mapsa.dao.InformationDao;
import com.mapsa.model.Account;
import com.mapsa.model.Flight;
import com.mapsa.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserPageController {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private PublicPageController otherController;
    @Autowired
    private FlightDao flightDao;

    @RequestMapping("/home/information/{id}")
    public String findInformation(@PathVariable long id, Model model) {
        if (accountDao.isFindAccountById(id)) {
            Information information = informationDao.getInformationByAccountId(id);
            if (information == null) {
                information = new Information();
                information.setAccountId(id);
            }
            model.addAttribute("information", information);
            return "information";
        }
        return "redirect:/";
    }

    @RequestMapping("/home/information/update")
    public String updateInformation(@ModelAttribute Information information, Model model) {
        Account account = accountDao.getAccountById(information.getAccountId());
        if (account != null) {
            System.out.println(information.getId());
            informationDao.addInformation(information);
            model.addAttribute("account", account);
            return otherController.login(account, model);
        }
        return "redirect:/";
    }

    @RequestMapping("/home/account/{id}")
    public String findAccount(@PathVariable long id, Model model) {
        Account account = accountDao.getAccountById(id);
        if (account != null && !account.getEmail().isEmpty()) {
            model.addAttribute("account", account);
            return "edit";
        }
        return "redirect:/";
    }

    @RequestMapping("/home/account/update")
    public String updateAccount(@ModelAttribute Account account, Model model) {
        accountDao.editAccount(account);
        model.addAttribute("account", account);
        return otherController.login(account, model);
    }

    @RequestMapping("/home")
    public String login(@ModelAttribute Account account, @ModelAttribute Information information, Model model) {

        Long idInf = information.getAccountId();
        Long idAccount = account.getId();

        if (idAccount != 0) {
            account = accountDao.getAccountById(idAccount);
            List<Flight> flights = flightDao.findAllFlight();
            model.addAttribute("flights", flights);
            model.addAttribute("account", account);
            return "home";
        } else if (idInf != 0) {
            account = accountDao.getAccountById(idInf);
            List<Flight> flights = flightDao.findAllFlight();
            model.addAttribute("flights", flights);
            model.addAttribute("account", account);
            return "home";
        }
        return "redirect:/";
    }
    
}
