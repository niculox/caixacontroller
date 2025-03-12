package com.example.caixacontrol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.caixacontrol.service.ATMSystemService;

@RestController
@RequestMapping("/atm")
public class ATMSystemController {
    
    private final ATMSystemService atmSystemService;

    public ATMSystemController(ATMSystemService atmSystemService) {
        this.atmSystemService = atmSystemService;
    }

    //deposita um valor no caixa
    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody float value) {
        atmSystemService.depositar(value);
        return ResponseEntity.ok().build();
    }

    //saca um valor do caixa
    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody float value) {
        atmSystemService.sacar(value);
        return ResponseEntity.ok().build();
    }

    //consulta o saldo do caixa
    @GetMapping("/balance")
    public ResponseEntity<?> balance() {
        atmSystemService.consultarSaldo();
        return ResponseEntity.ok().build();
    }

    //consulta entradas por tipo
    @GetMapping("/getByType/{type}")
    public ResponseEntity<?> findByType(@PathVariable String type) {
        return ResponseEntity.ok(atmSystemService.consultarEntradasPorTipo(type));
    }

    //consulta entradas por cliente
    @GetMapping("/getByClient/{client}")
    public ResponseEntity<?> findByClient(@PathVariable String client) {
        return ResponseEntity.ok(atmSystemService.consultarEntradasPorCliente(client));
    }

    //consulta entradas por data
    @GetMapping("/getByDate/{date}")
    public ResponseEntity<?> findByDate(@PathVariable String date) {
        return ResponseEntity.ok(atmSystemService.consultarEntradasPorData(date));
    }

}
