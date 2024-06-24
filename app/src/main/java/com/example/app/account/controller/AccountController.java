package com.example.app.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.account.model.Account;
import com.example.app.account.service.AccountService;

@Controller
@Scope("request")
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String index(Model model) {
        // 全アカウント取得します。
        List<Account> accountList = accountService.getAllAccounts();
        model.addAttribute("accountList", accountList);
        return "account/accountList";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam String id) {
        // 指定されたidのアカウントを取得します。
        Optional<Account> account = accountService.getAccountById(Integer.valueOf(id));
        model.addAttribute("account", account);
        return "account/accountDetail";
    }
    
}
