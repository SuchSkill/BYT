package lab8.Part2.exercise01.src;

public class Matcher {
	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		// Check for length differences
		if (actual.length != expected.length)
			return false;

		// Clip "too-large" values
		for (int i = 0; i < actual.length; i++) {
			if (actual[i] > clipLimit) {
				actual[i] = clipLimit;
			}
			// Check that each entry within expected +/- delta
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		}
		return true;
	}
}