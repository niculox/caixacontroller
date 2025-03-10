package com.example.caixacontrol.repository;

import com.example.caixacontrol.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IEntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByClientId(Long client);
    List<Entry> findByDate(Date date);
    List<Entry> findByEntryType(String entryType);
}
