package com.example.caixacontrol.service;

import com.example.caixacontrol.model.Entry;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.caixacontrol.repository.IEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    
    @Autowired
    private IEntryRepository entryRepository;

    public void salvar(Entry entry){
        entryRepository.save(entry);
    }

    public void editar(Entry entry){
        entryRepository.save(entry);
    }

    public void excluir(Long id){
        entryRepository.deleteById(id);
    }

    public Entry buscarPorId(Long id){
        return entryRepository.findById(id).get();
    }

    public List<Entry> buscarTodos(){
        return entryRepository.findAll();
    }

    public List<Entry> buscarPorCliente(Long client){
        return entryRepository.findByClientId(client);
    }

    public List<Entry> buscarPorData(Date date){
        return entryRepository.findByDate(date);
    }

    public List<Entry> buscarPorTipo(String type){
        return entryRepository.findByEntryType(type);
    }
}
