package com.luisfelipebp.wirecardspring.repository;

import com.luisfelipebp.wirecardspring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
