package com.purtzman.gestionFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purtzman.gestionFinance.model.Transaction;
import com.purtzman.gestionFinance.repository.TransactionRepository;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

   @Autowired
   private TransactionRepository transactionRepository;

   @GetMapping
   public List<Transaction> getAllTransactions() {
      return transactionRepository.findAll();
   }

   @PostMapping
   public Transaction createTransaction(@RequestBody Transaction transaction) {
      return transactionRepository.save(transaction);
   }

}
