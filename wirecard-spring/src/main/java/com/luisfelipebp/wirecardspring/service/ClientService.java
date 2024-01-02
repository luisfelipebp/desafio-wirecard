package com.luisfelipebp.wirecardspring.service;

import com.luisfelipebp.wirecardspring.model.Client;
import com.luisfelipebp.wirecardspring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
}
