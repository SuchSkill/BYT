package lab8.Part2.exercise04.src;

import java.io.*;


public class PersonWriter {

	public static void writePerson(Writer out, Person person, NameOrder order) throws IOException {

		switch (order) {
			case FML:
				out.write(person.first);
				out.write(" ");
				if (person.middle != null) {
					out.write(person.middle);
					out.write(" ");
				}
				out.write(person.last);
				break;
			case LFM:
				out.write(person.last);
				out.write(", ");
				out.write(person.first);
				if (person.middle != null) {
					out.write(" ");
					out.write(person.middle);
				}
				break;
		}
	}
}
