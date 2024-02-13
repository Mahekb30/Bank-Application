package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
  Loan findByCustomerId(int customerId);
}
