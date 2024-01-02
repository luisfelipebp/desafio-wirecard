package com.luisfelipebp.wirecardspring.controller;

import com.luisfelipebp.wirecardspring.model.Buyer;
import com.luisfelipebp.wirecardspring.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyer")
    public ResponseEntity<List<Buyer>> findAllBuyers(){
        return ResponseEntity.ok().body(buyerService.findAllBuyers());
    }
}
