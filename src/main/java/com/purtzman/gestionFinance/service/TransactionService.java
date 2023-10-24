package com.purtzman.gestionFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purtzman.gestionFinance.model.Transaction;
import com.purtzman.gestionFinance.repository.TransactionRepository;

@Service
public class TransactionService {

   @Autowired
   private TransactionRepository transactionRepository;

   @Autowired
   private AccountService accountService;


   public Transaction addTransaction(Transaction transaction) {
      if (!accountService.hasAccounts()) {
          throw new IllegalStateException("Cannot add a transaction without an existing account.");
      }
      return transactionRepository.save(transaction);
  }

   public Transaction createTransaction(Transaction transaction) {
      return transactionRepository.save(transaction);
   }

   public List<Transaction> getAllTransactions() {
      return transactionRepository.findAll();
   }

}