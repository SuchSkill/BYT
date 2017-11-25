package lab6.b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
	}

	@Test
	public void testGetRate() {
		assertEquals(0.15, SEK.getRate(), 0.0001);
	}
	
	@Test
	public void testSetRate() {
		DKK.setRate(6.0);
		assertEquals(6.0, DKK.getRate(), 0.0001);

	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(1500, (int)EUR.universalValue(1000));

	}

	@Test
	public void testValueInThisCurrency() {
		assertEquals(100,(int)EUR.valueInThisCurrency(1000, SEK));
	}

}
