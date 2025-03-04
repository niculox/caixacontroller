package com.example.caixacontrol.model;

import org.springframework.beans.factory.annotation.Autowired;


public class Client {

    @Autowired
    private Long id;
    private String name;
    private String cpf;
    private String phone;
}
