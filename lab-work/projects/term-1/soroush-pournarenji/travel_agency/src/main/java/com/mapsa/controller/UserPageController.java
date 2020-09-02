package com.mapsa.controller;

import com.mapsa.dao.AccountDao;
import com.mapsa.dao.FlightDao;
import com.mapsa.dao.InformationDao;
import com.mapsa.dao.PersonDao;
import com.mapsa.model.Account;
import com.mapsa.model.Information;
import com.mapsa.model.Person;
import com.mapsa.service.AccountService;
import com.mapsa.service.FlightService;
import com.mapsa.service.InformationService;
import com.mapsa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/home")
public class UserPageController {
    @Autowired
    private PublicPageController otherController;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    AccountService accountService;
    @Autowired
    InformationService informationService;
    @Autowired
    FlightService flightService;
    @Autowired
    PersonService personService;

    @RequestMapping
    public String login(@ModelAttribute Account account, @ModelAttribute Information information, Model model,HttpSession httpSession) {
        Long accountId = (Long) httpSession.getAttribute("accountId");
        if(accountId != null){
            httpSession.removeAttribute("personList");
            model.addAttribute("flights", flightService.flightList());
            model.addAttribute("account",
                    accountService.getAccountById(accountId));
            return "home";
        }
        return "redirect:/";
    }

    @RequestMapping("/information/{id}")
    public String findInformation(@PathVariable long id, Model model) {
        if (accountService.isFindAccountById(id)) {
            model.addAttribute("information", informationService.getInformationByAccountId(id));
            return "information";
        }
        return "redirect:/";
    }

    @RequestMapping("/information/update")
    public String updateInformation(@ModelAttribute Information information, Model model) {
        Account account = accountService.getAccountByInformation(information);
        if (account != null) {
            informationService.addOrEditInformation(information);
            model.addAttribute("account", account);
            return otherController.login(account, model);
        }
        return "redirect:/";
    }

    @RequestMapping("/account/{id}")
    public String findAccount(@PathVariable long id, Model model) {
        Account account = accountService.getAccountById(id);
        if (account != null && !account.getEmail().isEmpty()) {
            model.addAttribute("account", account);
            return "edit";
        }
        return "redirect:/";
    }

    @RequestMapping("/account/update")
    public String updateAccount(@ModelAttribute Account account, Model model) {
        model.addAttribute("account", accountService.editAccount(account));
        return otherController.login(account, model);
    }

    @RequestMapping("/shopping/{flightId}")
    public String shopping(@PathVariable long flightId, Model model, HttpSession httpSession) {
        model.addAttribute("flight", flightService.getFlightById(flightId));
        List<Person> people = personService.findAllPeronByAccountId((Long) httpSession.getAttribute("accountId"));
        model.addAttribute("people", people);
        Set<Person> personList;
        if (httpSession.getAttribute("personList") == null) {
            personList = new HashSet<>();
            httpSession.setAttribute("personList", personList);
        } else {
            personList = (Set<Person>) httpSession.getAttribute("personList");
        }
        model.addAttribute("personList", personList);
        model.addAttribute("person", new Person());
        return "shopping";
    }

    @RequestMapping("/addperson/{flightId}")
    public String addPerson(@ModelAttribute Person person, @PathVariable long flightId, HttpSession httpSession) {
        Set<Person> personList = (Set<Person>) httpSession.getAttribute("personList");
        Long accountId = (Long) httpSession.getAttribute("accountId");
        Person person1 = personService.addPersonToListPersonList(accountId, person);
        personList.add(person1);
        return "redirect:/home/shopping/" + flightId;
    }

    @RequestMapping("/addcart/{flightId}")
    public String addToCart(@PathVariable long flightId, @ModelAttribute Person person) {
        Set<Person> personList = (Set<Person>) httpSession.getAttribute("personList");
        Person person1 = personService.getPersonById(person.getId());
        personList.add(person1);
        return "redirect:/home/shopping/" + flightId;
    }

    @RequestMapping("/delete/{flightId}&{id}")
    public String deleteToCart(@PathVariable long flightId, @PathVariable long id) {
        Set<Person> personList = (Set<Person>) httpSession.getAttribute("personList");
        Person person = personService.getPersonById(id);
        personList.remove(person);
        return "redirect:/home/shopping/" + flightId;
    }

    @RequestMapping("/description/{flightId}")
    public String description(@PathVariable long flightId, Model model, HttpSession httpSession) {
        model.addAttribute("flight", flightService.getFlightById(flightId));
        return "description";
    }
}
