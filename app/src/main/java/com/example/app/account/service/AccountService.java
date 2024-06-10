package com.example.app.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.account.model.Account;
import com.example.app.account.repository.AccountRepository;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    @Transactional
    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }
}
