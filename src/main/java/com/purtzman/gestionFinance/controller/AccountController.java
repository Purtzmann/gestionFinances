package com.purtzman.gestionFinance.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.purtzman.gestionFinance.model.Account;
import com.purtzman.gestionFinance.repository.AccountRepository;


@RestController
@RequestMapping("/api/account")
public class AccountController {
   

   @Autowired
   private AccountRepository accountRepository;


    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

}
