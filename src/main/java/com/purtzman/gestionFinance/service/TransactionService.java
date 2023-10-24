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

   // Create a new transaction
   public Transaction createTransaction(Transaction transaction) {
      return transactionRepository.save(transaction);
   }

   // Return all transactions
   public List<Transaction> getAllTransactions() {
      return transactionRepository.findAll();
   }

}