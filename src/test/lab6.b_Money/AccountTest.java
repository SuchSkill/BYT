package lab6.b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	Money SEK100;
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
		SEK100 = new Money(10000, SEK);
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("1234", 1, 2, SEK100, SweBank, "Alice");
		testAccount.removeTimedPayment("1234");
		assertTrue(!testAccount.timedPaymentExists("1234"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1234", 1, 2, SEK100, SweBank, "Alice");
		assertEquals(10000000,(int)testAccount.getBalance().getAmount());
		assertEquals(1000000,(int)SweBank.getBalance("Alice"));
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		assertEquals(9990000,(int)testAccount.getBalance().getAmount());
		assertEquals(1010000,(int)SweBank.getBalance("Alice"));

	}

	@Test
	public void testAddWithdraw() {
		Account testAccount3 = new Account("HanSolo", SEK);
		testAccount3.deposit(new Money(1000000, SEK));
		testAccount3.withdraw(new Money(100000, SEK));
		assertEquals(900000, (int)testAccount3.getBalance().getAmount());
	}
	
	@Test
	public void testGetBalance() {
		Account testAccount2 = new Account("Han", SEK);
		testAccount2.deposit(new Money(1000000, SEK));
		assertEquals(1000000, (int) testAccount2.getBalance().getAmount());
	}
}
