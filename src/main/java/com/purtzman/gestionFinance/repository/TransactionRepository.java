package com.purtzman.gestionFinance.repository;

import com.purtzman.gestionFinance.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
