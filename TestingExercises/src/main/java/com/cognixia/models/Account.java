package com.cognixia.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Account {
    ArrayList<Claim> claims;

    public Account() {
        // new account created
        this.claims = new ArrayList<>();
    }

    public void addClaim(String name, LocalDate date) {
        this.claims.add(new Claim(name, date));
    }

    public void addClaim(String name, String dateString) {
        this.addClaim(name, this.convertStrToLocal(dateString));
    }

    public void addClaim(String name) {
        this.addClaim(name, LocalDate.now());
    }

    public String listClaims() {
        String output = "";
        Iterator<Claim> claimIter = claims.iterator();
        while (claimIter.hasNext()) {
            output += claimIter.next().printClaim();
            if (claimIter.hasNext())
                output += "\n";
        }
        return output;
    }

    protected LocalDate convertStrToLocal(String dateString) {
        String[] dateArray = dateString.split("-");
        return LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]),
                Integer.parseInt(dateArray[2]));
    }
}
