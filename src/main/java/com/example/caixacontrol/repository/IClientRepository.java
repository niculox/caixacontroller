package com.example.caixacontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caixacontrol.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
