package com.example.caixacontrol.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caixacontrol.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{
    List<Client> findByIdClients(Long idClients);
}
