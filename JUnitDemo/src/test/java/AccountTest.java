import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.cognixia.jump.Account;
import com.cognixia.jump.OverdraftException;

public class AccountTest {
	
	
	@Test
	@DisplayName("Testing the Deposit Method")
	void testDeposit() {
		
		int initialAmount = 1000;
		Account	account = new Account(initialAmount);
		
		int depositAmount = 100;
		
		account.deposit(depositAmount);
		
		assertEquals(initialAmount + depositAmount, account.getBalance());
	}
	
	@Test
	void testWithdraw() throws OverdraftException {
		int initialAmount = 1000;
		Account	account = new Account(initialAmount);
		
		int withdrawAmount = 100;
		
		account.withdraw(100);
		
		assertEquals(initialAmount - withdrawAmount, account.getBalance());
	}
	
	@Test
	void testDepositNegative() {
		int initialAmount = 1000;
		Account	account = new Account(initialAmount);
		
		int depositAmount = -100;
		
		account.deposit(depositAmount);
		
		assertEquals(initialAmount, account.getBalance());
	}
	
	@Test
	void testWithDrawNegative() throws OverdraftException {
		int initialAmount = 1000;
		Account	account = new Account(initialAmount);
		
		int withdrawAmount = -100;
		
		account.withdraw(withdrawAmount);
		
		assertEquals(initialAmount, account.getBalance());
	}
	
	@Test
	void testCreateNegativeAmount() {
		int initialAmount = -1000;
		Account	account = new Account(initialAmount);
		
		assertTrue(account.getBalance() >= 0);
	}
	
	@Test
	void testOverDraft() {
		int initialAmount = 1000;
		Account	account = new Account(initialAmount);
		
		int withdrawAmount = 10000;
		
		assertThrows(OverdraftException.class, () -> account.withdraw(withdrawAmount));
	}
	
	@RepeatedTest(value = 10, name = "Test number {currentRepetition} out of {totalRepetitions}")
	@DisplayName("Testing random withdraw amounts")
	void repeatedTest() throws OverdraftException {
		int initialAmount = 1000;
		Account	account = new Account(initialAmount);
		
		int withdrawAmount = (int) ((Math.random() * 999) + 1);
		
		account.withdraw(withdrawAmount);
		
		assertTrue(initialAmount > account.getBalance());
	}
	
	@ParameterizedTest
//	@ValueSource(ints = {1000, 2000, 200, 1111, 5, 12})
	@MethodSource("getPositiveNumbers")
	void testValidBalance(int initialAmount) {
		Account account = new Account(initialAmount);
		
		assertTrue(initialAmount == account.getBalance());
	}
	
	@ParameterizedTest
//	@ValueSource(ints = {-1, -20, -100})
//	@CsvSource({"-1","-20","-100"})
	@CsvFileSource(resources = "./testdata.csv")
	void testInvalidBalance(int initialAmount) {
		Account account = new Account(initialAmount);
		
		assertTrue(0 == account.getBalance());
	}

	static List<Integer> getPositiveNumbers(){
		return Arrays.asList(1000, 2000, 200, 1111, 5, 12);
	}
	
}
