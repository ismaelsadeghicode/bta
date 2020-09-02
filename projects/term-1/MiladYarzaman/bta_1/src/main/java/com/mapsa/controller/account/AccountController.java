package com.mapsa.controller.account;

import com.mapsa.models.Account;
import com.mapsa.services.account.AccountService;
import com.mapsa.services.account.ConstVariable;
import com.mapsa.services.account.CustomExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/create")
    public String createAccount(Model model,@ModelAttribute Account account){
        try {
            accountService.createAccount(account);
            model.addAttribute("error", ConstVariable.REGISTER_SUCCESFULLY);
            return "error";
        }catch (CustomExeption customExeption){
           model.addAttribute("error", customExeption.getMessage());
            return "error";
        }
    }
    @RequestMapping("/registerPage")
    public String registerPage(Model model){
        model.addAttribute("account",new Account());
              return "register";
    }

    @RequestMapping("/login")
    public String registerPage(){
        System.out.println("login");
        return "register";
    }

}
