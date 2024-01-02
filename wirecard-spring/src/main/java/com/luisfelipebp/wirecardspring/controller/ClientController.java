package com.luisfelipebp.wirecardspring.controller;

import com.luisfelipebp.wirecardspring.model.Client;
import com.luisfelipebp.wirecardspring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public ResponseEntity<List<Client>> findAllClients(){
        return ResponseEntity.ok().body(clientService.findAllClients());
    }
}
