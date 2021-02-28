package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.PaymentSheet;

@Repository
public interface PaymentSheetRepository extends JpaRepository<PaymentSheet, Long> {

}
