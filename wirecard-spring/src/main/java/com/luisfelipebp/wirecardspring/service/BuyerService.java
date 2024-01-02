package com.luisfelipebp.wirecardspring.service;

import com.luisfelipebp.wirecardspring.model.Buyer;
import com.luisfelipebp.wirecardspring.model.Client;
import com.luisfelipebp.wirecardspring.repository.BuyerRepository;
import com.luisfelipebp.wirecardspring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> findAllBuyers(){
        return buyerRepository.findAll();
    }
}
