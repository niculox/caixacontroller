package com.example.caixacontrol.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caixacontrol.model.Entry;

public interface IEntryRepository extends JpaRepository<Entry, Long>{
    List<Entry> findByClientId(Long clientId);
    List<Entry> findByDate(Date date);
    List<Entry> findByType(String type);
}
