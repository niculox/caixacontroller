package com.example.caixacontrol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    //fecha o caixa
    @GetMapping("/close")
    public ResponseEntity<?> close() {
        atmSystemService.fecharCaixa();
        return ResponseEntity.ok().build();
    }

    //abre o caixa
    @GetMapping("/open")
    public ResponseEntity<?> open() {
        atmSystemService.abrirCaixa();
        return ResponseEntity.ok().build();
    }

    //define o valor inicial do caixa
    @PostMapping("/setInitial")
    public ResponseEntity<?> setInitial(@RequestBody float value) {
        atmSystemService.setCaixaInicial(value);
        return ResponseEntity.ok().build();
    }

}
