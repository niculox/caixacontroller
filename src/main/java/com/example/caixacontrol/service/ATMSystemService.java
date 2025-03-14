package com.example.caixacontrol.service;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


@Transactional
@Service
public class ATMSystemService {

    private float caixaAtual;
    private float caixaInicial;
    private float caixaFinal;

    public void depositar(float valor){
        if (valor > 0) {
            caixaAtual += valor;
        } else {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }

    }

    public void sacar(float valor){
        if (valor > 0) {
            if (caixaAtual >= valor) {
                caixaAtual -= valor;
            } else {
                throw new IllegalArgumentException("Saldo insuficiente para retirada.");
            }
        } else {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
    }

    public void consultarSaldo(){
        System.out.println("Saldo atual: " + caixaAtual);
    }

    public void fecharCaixa(){
        caixaFinal = caixaAtual;
        System.out.println("Caixa fechado. Saldo final: " + caixaFinal);
    }

    public void abrirCaixa(){
        caixaAtual = caixaInicial;
        System.out.println("Caixa aberto. Saldo inicial: " + caixaInicial);
    }

    public void setCaixaInicial(float valor){
        if (valor >= 0) {
            caixaInicial = valor;
        } else {
            throw new IllegalArgumentException("O valor do caixa inicial deve ser positivo.");
        }
    }

}
