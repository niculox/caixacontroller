package com.example.caixacontrol.model;

public class Entry {
    
    private Client client;
    private float value;
    private String entryType;
    private String date;
    
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    public String getEntryType() {
        return entryType;
    }
    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    

}
