package com.example.caixacontrol.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caixacontrol.model.ATMSystem;

public interface IATMSystemRepository extends JpaRepository<ATMSystem, Long>{
    List<ATMSystem> findByOutput(float output);
}
