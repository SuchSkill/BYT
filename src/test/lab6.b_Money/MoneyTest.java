package lab6.b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    Currency SEK, DKK, NOK, EUR;
    Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;

    @Before
    public void setUp() throws Exception {
        SEK = new Currency("SEK", 0.15);
        DKK = new Currency("DKK", 0.20);
        EUR = new Currency("EUR", 1.5);
        SEK100 = new Money(10000, SEK);
        EUR10 = new Money(1000, EUR);
        SEK200 = new Money(20000, SEK);
        EUR20 = new Money(2000, EUR);
        SEK0 = new Money(0, SEK);
        EUR0 = new Money(0, EUR);
        SEKn100 = new Money(-10000, SEK);
    }

    @Test
    public void testGetAmount() {
        assertEquals(10000, (int) SEK100.getAmount());
    }

    @Test
    public void testGetCurrency() {
        assertEquals(SEK, SEK100.getCurrency());
    }

    @Test
    public void testToString() {
        assertEquals("100.0 SEK", SEK100.toString());
    }

    @Test
    public void testGlobalValue() {
        assertEquals(1500, (int) EUR10.universalValue());
    }

    @Test
    public void testEqualsMoney() {
        assertTrue(SEK100.equals(SEK100));
    }

    @Test
    public void testAdd() {
        Money add = EUR10.add(EUR10);
        assertEquals(2000, (int)add.getAmount());
    }

    @Test
    public void testSub() {
        Money sub = EUR20.sub(EUR10);
        assertEquals(1000, (int)sub.getAmount());

    }

    @Test
    public void testIsZero() {
        assertTrue(EUR0.isZero());
    }

    @Test
    public void testNegate() {
        assertEquals(10000, (int)SEKn100.negate().getAmount());
    }

    @Test
    public void testCompareTo() {
        assertEquals(0, EUR10.compareTo(SEK100));
    }
}
