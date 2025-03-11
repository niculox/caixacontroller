package com.example.caixacontrol.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caixacontrol.model.Client;
import com.example.caixacontrol.repository.IClientRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ClientService {
    
    @Autowired 
    private IClientRepository clientRepository;

    public Client salvar(Client client) {
        return clientRepository.save(client); 
    }

    public void editar(Client client){
        clientRepository.save(client);
    }

    public void excluir(Long id){
        clientRepository.deleteById(id);
    }

    public Client buscarPorId(Long id){
        return clientRepository.findById(id).get();
    }

    public List<Client> buscarTodos(){
        return clientRepository.findAll();
    }

}
