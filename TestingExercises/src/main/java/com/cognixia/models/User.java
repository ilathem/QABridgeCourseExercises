package com.cognixia.models;

import java.time.LocalDate;
import java.util.Iterator;

public class User extends Account {

    public User() {
        super();
    }

    public String searchClaims(LocalDate startDate, LocalDate endDate) {
        String output = "";
        Iterator<Claim> claimIter = claims.iterator();
        boolean isFirstTerm = true;
        while (claimIter.hasNext()) {
            Claim claim = claimIter.next();
            if (claim.getDate().toEpochDay() >= startDate.toEpochDay() &&
                    claim.getDate().toEpochDay() <= endDate.toEpochDay()) {
                if (!isFirstTerm)
                    output += "\n";
                output += claim.printClaim();
                isFirstTerm = false;
            }
        }
        return output;
    }

    public String searchClaims(String startDate, String endDate) {
        return this.searchClaims(
                this.convertStrToLocal(startDate),
                this.convertStrToLocal(endDate));
    }

}
