package com.cognixia.models;

public class Provider extends Account {
    public Provider() {
        super();
    }
    
    public void addClaims(String[][] claims) {
        for (int i = 0; i < claims.length; i++) {
            this.addClaim(claims[i][0], claims[i][1]);
        }
    }
}
