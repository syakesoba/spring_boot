package com.example.app.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.account.model.Account;
import com.example.app.account.service.AccountService;

@Controller
@Scope("request")
@RequestMapping("account")
public class AccountDetailController {

    private final AccountService accountService;

    @Autowired
    public AccountDetailController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam("id") Integer id) {
        // 指定されたidのアカウントを取得します。
        Account account = accountService.getAccountById(id).orElse(null);
        model.addAttribute("account", account);
        return "account/accountDetail";
    }
    
}
