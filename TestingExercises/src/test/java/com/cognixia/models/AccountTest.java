package com.cognixia.models;

import org.junit.jupiter.api.Test;

public class AccountTest {

  // 1. As a member, I should be able to view a list of my past claims so I can
  // verify my claim status
  @Test
  void testListClaims() {
    User user = new User();
    user.addClaim("claim1", "2025-01-01");
    user.addClaim("claim2", "2025-01-20");
    user.addClaim("claim3", "2025-02-01");
    String expectedOutput = "claim1 2025-01-01\nclaim2 2025-01-20\nclaim3 2025-02-01";
    assertEquals(user.listClaims(), expectedOutput);
  }

  // 2. As a user, I should be able to search claims within a range of dates

  // 3. As a provider, I should be able to upload several claims at once and add
  // them to the database

}
