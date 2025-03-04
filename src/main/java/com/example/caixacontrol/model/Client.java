package com.example.caixacontrol.model;

import org.springframework.beans.factory.annotation.Autowired;


public class Client {

    @Autowired
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
