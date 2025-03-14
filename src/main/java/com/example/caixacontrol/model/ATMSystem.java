package com.example.caixacontrol.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ATM_SYSTEM")
public class ATMSystem extends AbstractEntity<Long>{

    @Column(nullable = false)
    private List<Entry> entries;

    @Column(nullable = false)
    private float caixaAtual;

    @Column(nullable = false)
    private float caixaInicial;

    @Column(nullable = false)
    private float caixaFinal;
    
}
