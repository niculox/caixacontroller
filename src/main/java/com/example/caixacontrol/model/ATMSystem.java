package com.example.caixacontrol.model;

import java.util.List;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATMSystem extends AbstractEntity<Long>{

    @Column(nullable = false)
    private List<Entry> entries;
    
}
