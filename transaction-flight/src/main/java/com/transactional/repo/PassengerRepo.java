package com.transactional.repo;

import com.transactional.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<PassengerInfo,Long> {
}
