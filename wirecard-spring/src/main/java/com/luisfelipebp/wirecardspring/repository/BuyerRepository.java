package com.luisfelipebp.wirecardspring.repository;

import com.luisfelipebp.wirecardspring.model.Buyer;
import com.luisfelipebp.wirecardspring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
