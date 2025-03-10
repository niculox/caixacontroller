package com.example.caixacontrol.repository;

import com.example.caixacontrol.model.Client;
import com.example.caixacontrol.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByClient(Client client);
    List<Entry> findByDate(String date);
    List<Entry> findByEntryType(String entryType);
}
