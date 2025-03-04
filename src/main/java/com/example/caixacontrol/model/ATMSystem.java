package com.example.caixacontrol.model;

import java.util.List;

public class ATMSystem {

    private List<Entry> entries;
    private float output;

    public List<Entry> getEntries() {
        return entries;
    }
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
    public float getOutput() {
        return output;
    }
    public void setOutput(float output) {
        this.output = output;
    }
    
}
