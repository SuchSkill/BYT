package lab8.Part2.exercise01.src;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class MatcherTest {

	private Matcher matcher;
	private int[] expected;
	private int clipLimit;
	private int delta;

	@Before
	public void init(){
		matcher = new Matcher();
		expected = new int[] { 10, 50, 30, 98 };
		clipLimit = 100;
		delta = 5;
	}
	@Test
	public void testDataFail1() {
		int[] actual = new int[] { 10, 60, 30, 98 };
		assertTrue(!matcher.match(expected, actual, clipLimit, delta));
	}
	@Test
	public void testDataFail2() {
		int[] actual = new int[] { 10, 50, 30 };
		assertTrue(!matcher.match(expected, actual, clipLimit, delta));
	}
	@Test
	public void testDataOkay() {
		int[] actual = new int[] { 12, 55, 25, 110 };
		assertTrue(matcher.match(expected, actual, clipLimit, delta));
	}
}
