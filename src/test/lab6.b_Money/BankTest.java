package lab6.b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	Money SEK100, DKK50, SEK200;

	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		Nordea.openAccount("Lola");
		DanskeBank.openAccount("Gertrud");
		DanskeBank.openAccount("Grem");

		DKK50 = new Money(5000, DKK);
		SEK100 = new Money(10000, SEK);
		SEK200 = new Money(20000, SEK);
	}

	@Test
	public void testGetName() {
		assertEquals("Nordea", Nordea.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, Nordea.getCurrency());
	}
	@Test(expected = AccountExistsException.class)
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("Ulrika");

	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", SEK100);
		assertEquals(10000, (int)SweBank.getBalance("Bob"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		Nordea.deposit("Bob", SEK200);
		Nordea.withdraw("Bob", SEK100);
		assertEquals(10000, (int)Nordea.getBalance("Bob"));
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", SEK100);
		assertEquals(10000,(int)SweBank.getBalance("Ulrika"));

	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		Integer gertrud = Nordea.getBalance("Bob");
		DanskeBank.deposit("Gertrud", DKK50);
		DanskeBank.transfer("Gertrud", Nordea, "Bob", DKK50);
		assertEquals(0, (int)DanskeBank.getBalance("Gertrud"));
		assertEquals( 6666,(int)Nordea.getBalance("Bob"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		Nordea.deposit("Lola", SEK200);
		Nordea.addTimedPayment("Lola", "123", 3, 2,
				SEK100, DanskeBank, "Grem");
		Nordea.tick();
		assertEquals(20000,(int)Nordea.getBalance("Lola"));
		assertEquals(0,(int)DanskeBank.getBalance("Grem"));
		Nordea.tick();
		Nordea.tick();
		assertEquals(10000,(int)Nordea.getBalance("Lola"));
		assertEquals(7500,(int)DanskeBank.getBalance("Grem"));
		Nordea.tick();
		Nordea.tick();
		Nordea.tick();
		Nordea.tick();
		assertEquals(0,(int)Nordea.getBalance("Lola"));
		assertEquals(15000,(int)DanskeBank.getBalance("Grem"));
	}
}
