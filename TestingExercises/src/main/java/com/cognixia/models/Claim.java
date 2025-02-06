package com.cognixia.models;

import java.time.LocalDate;

public class Claim {
    private String name;
    private LocalDate date;
    public Claim(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
    
    public String printClaim() {
        return name + " " + date.toString();
    }
    
    public LocalDate getDate() {
        return this.date;
    }
}
