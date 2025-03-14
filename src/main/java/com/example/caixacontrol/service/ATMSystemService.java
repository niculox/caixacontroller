package com.example.caixacontrol.service;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


@Transactional
@Service
public class ATMSystemService {

    private float totalCaixa = 0;

    public void depositar(float valor){
        if (valor > 0) {
            totalCaixa += valor;
        } else {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }

    }

    public void sacar(float valor){
        if (valor > 0) {
            if (totalCaixa >= valor) {
                totalCaixa -= valor;
            } else {
                throw new IllegalArgumentException("Saldo insuficiente para retirada.");
            }
        } else {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
    }

    public void consultarSaldo(){
        System.out.println("Saldo atual: " + totalCaixa);
    }

}
