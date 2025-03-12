package com.example.caixacontrol.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.caixacontrol.model.Entry;
import com.example.caixacontrol.service.EntryService;

@RestController
@RequestMapping("/entry")
public class EntryController {
    
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    //cria uma nova entrada (RESOLVER ENTRADA DO CLIENTE NULL)
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody Entry entry, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Entry entryCreated = entryService.salvar(entry);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entryCreated.getId())
                .toUri();
 
        return ResponseEntity.created(location).body(entryCreated);
    }

    //busca uma entrada por id
    @GetMapping("/get/{id}")
    public ResponseEntity<Entry> findById(@PathVariable Long id) {
        var entry = entryService.buscarPorId(id);
        return ResponseEntity.ok(entry);
    }

    //atualiza uma entrada
    @PutMapping("/put/{id}")
    public ResponseEntity<Entry> update(@PathVariable Long id, @RequestBody Entry entry) {
        entry.setId(id);
        entryService.editar(entry);
        return ResponseEntity.ok(entry);
    }

    //exclui uma entrada
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        entryService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    //busca todas as entradas
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(entryService.buscarTodos());
    }

    //busca entradas por cliente
    //@GetMapping("/getByClient/{client}")
    // public ResponseEntity<?> findByClient(String client) {
    //    return ResponseEntity.ok(entryService.buscarPorCliente(client));
    //}

    //busca entradas por data
    @GetMapping("/getByDate/{date}")
    public ResponseEntity<?> findByDate(@PathVariable String date) {
        return ResponseEntity.ok(entryService.buscarPorData(date));
    }

    //busca entradas por tipo
    @GetMapping("/getByType/{type}")
    public ResponseEntity<?> findByType(@PathVariable String type) {
        return ResponseEntity.ok(entryService.buscarPorTipo(type));
    }

}
