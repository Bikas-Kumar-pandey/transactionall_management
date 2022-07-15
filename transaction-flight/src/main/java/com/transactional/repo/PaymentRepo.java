package com.transactional.repo;

import com.transactional.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentInfo,String> {
}
