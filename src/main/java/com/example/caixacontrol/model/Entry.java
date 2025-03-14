package com.example.caixacontrol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ENTRY")
public class Entry extends AbstractEntity<Long> {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "entry_type", nullable = false)
    private String entryType;

    @Column(nullable = false)
    private String date;

    @Column
    private String description;

    public Long getClientId() {
        return client != null ? client.getId() : null;
    }
}
