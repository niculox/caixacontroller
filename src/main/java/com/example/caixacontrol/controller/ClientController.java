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

import com.example.caixacontrol.model.Client;
import com.example.caixacontrol.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //cria um novo cliente 
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody Client client, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Client clientCreated = clientService.salvar(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(clientCreated);
    }

    //busca um cliente por id
    @GetMapping("/get/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        var client = clientService.buscarPorId(id);
        return ResponseEntity.ok(client);
    }

    //atualiza um cliente
    @PutMapping("/put/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        clientService.editar(client);
        return ResponseEntity.ok(client);
    }

    //busca todos os clientes
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(clientService.buscarTodos());
    }

    //deleta um cliente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clientService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
