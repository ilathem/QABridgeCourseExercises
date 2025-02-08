package com.cognixia.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountTest {

  // 1. As a member, I should be able to view a list of my past claims so I can
  // verify my claim status
  // This is assuming that member == "Account" with limited access.
  @Test
  void testListClaims() {
    Account user = new Account();
    user.addClaim("claim1", "2025-01-01");
    user.addClaim("claim2", "2025-01-20");
    user.addClaim("claim3", "2025-02-01");
    String expectedOutput = "claim1 2025-01-01\nclaim2 2025-01-20\nclaim3 2025-02-01";
    assertEquals(expectedOutput, user.listClaims());
  }

  // 2. As a user, I should be able to search claims within a range of dates
  // This is assuming that the user == "User", inherting member access with 
  // additional search features.
  @Test
  void testSearchClaims() {
    User user = new User();
    user.addClaim("claim1", "2025-01-01");
    user.addClaim("claim2", "2025-01-20");
    user.addClaim("claim3", "2025-02-01");
    String expectedOutput = "claim1 2025-01-01\nclaim2 2025-01-20";
    String actualOutput = user.searchClaims("2025-01-01", "2025-01-31");
    assertEquals(expectedOutput, actualOutput);
  }

  // 3. As a provider, I should be able to upload several claims at once and add
  // them to the database
  @Test
  void testUploadSeveralClaims() {
    Provider provider = new Provider();
    String[][] testArr = new String[3][2];
    testArr[0][0] = "claim1";
    testArr[1][0] = "claim2";
    testArr[2][0] = "claim3";
    testArr[0][1] = "2025-01-01";
    testArr[1][1] = "2025-01-20";
    testArr[2][1] = "2025-02-01";
    provider.addClaims(testArr);
    String expectedOutput = "claim1 2025-01-01\nclaim2 2025-01-20\nclaim3 2025-02-01";
    assertEquals(expectedOutput, provider.listClaims());
  } 

}
