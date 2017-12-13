package lab8.Part2.exercise04.src;// The Person class has multiple clients, but all of the clients are in
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;

public class PersonClientsTest {

    private Person bobSmith;
    private Person jennyJJones;

    @Before
    public void inti() {
        bobSmith = new Person("Smith", "Bob", null);
        jennyJJones = new Person("Jones", "Jenny", "J");
    }

    @Test
    public void testClientsToStringBobAndJenny() throws IOException {
        assertEquals("Smith, Bob", Client4.toString(bobSmith));
        assertEquals("Jones, Jenny J", Client4.toString(jennyJJones));
    }
    @Test
    public void testClientDisplayJenny() throws IOException {
        StringWriter out = new StringWriter();
        Client3.display(out, jennyJJones);
        assertEquals("Jones, Jenny J", out.toString());
    }

    @Test
    public void testClientDisplayBob() throws IOException {
        StringWriter out = new StringWriter();
        Client3.display(out, bobSmith);
        assertEquals("Smith, Bob", out.toString());
    }

    @Test
    public void testClientFromat() {
        assertEquals("Smith, Bob", Client2.formatPerson(bobSmith));
        assertEquals("Jones, Jenny J", Client2.formatPerson(jennyJJones));
    }

    @Test
    public void testClientWriter() throws IOException {
        StringWriter out = new StringWriter();
        Client1.printPerson(out, jennyJJones);
        assertEquals("Jenny J Jones", out.toString());
    }

    @Test
    public void testClientBobSmith() throws IOException {
        StringWriter out = new StringWriter();
        Client1.printPerson(out, bobSmith);
        assertEquals("Bob Smith", out.toString());
    }
}
