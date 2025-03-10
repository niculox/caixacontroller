package com.example.caixacontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caixacontrol.model.Client;
import com.example.caixacontrol.model.Entry;

import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@Service
public class ATMSystemService {

    private float totalCaixa = 0;
    private final EntryService entryService;

    @Autowired
    public ATMSystemService(EntryService entryService) {
        this.entryService = entryService;
    }

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

    public void consultarEntradasPorTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("O tipo de entrada não pode ser nulo ou vazio.");
        }

        List<Entry> entradasFiltradas = entryService.buscarPorTipo(tipo); 

        if (entradasFiltradas.isEmpty()) {
            System.out.println("Nenhuma entrada encontrada para o tipo: " + tipo);
        } else {
            System.out.println("Entradas do tipo " + tipo + ":");
            for (Entry entrada : entradasFiltradas) {
                System.out.println(entrada);
            }
        }
    }

    public void consultarEntradasPorCliente(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }

        List<Entry> entradasFiltradas = entryService.buscarPorCliente(client); 

        if (entradasFiltradas.isEmpty()) {
            System.out.println("Nenhuma entrada encontrada para o cliente: " + client);
        } else {
            System.out.println("Entradas do cliente " + client + ":");
            for (Entry entrada : entradasFiltradas) {
                System.out.println(entrada);
            }
        }
    }

    public void consultarEntradasPorData(String data) {
        if (data == null) {
            throw new IllegalArgumentException("A data não pode ser nula.");
        }

        List<Entry> entradasFiltradas = entryService.buscarPorData(data); 

        if (entradasFiltradas.isEmpty()) {
            System.out.println("Nenhuma entrada encontrada para a data: " + data);
        } else {
            System.out.println("Entradas na data " + data + ":");
            for (Entry entrada : entradasFiltradas) {
                System.out.println(entrada);
            }
        }
    }
}
