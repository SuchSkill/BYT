package lab8.Part2.exercise04.src;

public class PersonPrinter {

	public static String toString(Person person) {
		return person.last + ", " + person.first
				+ ((person.middle == null) ? "" : " " + person.middle);
	}

}
