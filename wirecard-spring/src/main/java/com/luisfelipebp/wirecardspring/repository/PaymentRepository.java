package com.luisfelipebp.wirecardspring.repository;

import com.luisfelipebp.wirecardspring.model.Buyer;
import com.luisfelipebp.wirecardspring.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
