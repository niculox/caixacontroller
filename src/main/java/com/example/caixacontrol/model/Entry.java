package com.example.caixacontrol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ENTRY")
public class Entry extends AbstractEntity<Long>{
    
    @Column(nullable = false)
    private Client client;

    @Column(nullable = false)
    private float value;

    @Column(nullable = false)
    private String entryType;

    @Column(nullable = false)
    private String date;

    

}
