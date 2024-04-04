package com.venkatesh.PaymentService.repository;

import com.venkatesh.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<TransactionDetails,Long> {
}
