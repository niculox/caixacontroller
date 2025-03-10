package com.example.caixacontrol.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caixacontrol.model.ATMSystem;

public interface IATMSystemRepository extends JpaRepository<ATMSystem, Long>{
    List<ATMSystem> findByClientId(Long client);
    List<ATMSystem> findByDate(Date date);
    List<ATMSystem> findByType(String type);
}
