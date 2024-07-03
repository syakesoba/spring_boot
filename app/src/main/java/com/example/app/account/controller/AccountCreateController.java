package com.example.app.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.account.model.Account;
import com.example.app.account.service.AccountService;

@Controller
@Scope("request")
@RequestMapping("account")
public class AccountCreateController {

    private final AccountService accountService;

    @Autowired
    public AccountCreateController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/createAccount_initDisplay")
    public String initDisplay(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "create";
    }

    @PostMapping("/createAccount_execute")
    public String execute(@ModelAttribute("account") Account account) {
        accountService.saveAccount(account);
        return "redirect:/";
    }
    
}
