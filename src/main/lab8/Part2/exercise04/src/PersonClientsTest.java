package lab8.Part2.exercise04.src;// The Person class has multiple clients, but all of the clients are in
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;

public class PersonClientsTest {

    private Person bobSmith;
    private Person jennyJJones;
    private NameOrder FML;
    private NameOrder LFM;

    @Before
    public void inti() {
        bobSmith = new Person("Smith", "Bob", null);
        jennyJJones = new Person("Jones", "Jenny", "J");
        FML = NameOrder.FML;
        LFM = NameOrder.LFM;

    }

    @Test
    public void testClientFromat() {
        assertEquals("Smith, Bob", PersonPrinter.toString(bobSmith));
        assertEquals("Jones, Jenny J", PersonPrinter.toString(jennyJJones));
    }
    @Test
    public void testClientsToStringBobAndJenny() throws IOException {
        assertEquals("Smith, Bob", PersonPrinter.toString(bobSmith));
        assertEquals("Jones, Jenny J", PersonPrinter.toString(jennyJJones));
    }

    @Test
    public void testClientDisplayJenny() throws IOException {
        StringWriter out = new StringWriter();
        PersonWriter.writePerson(out, jennyJJones, LFM);
        assertEquals("Jones, Jenny J", out.toString());
    }

    @Test
    public void testClientDisplayBob() throws IOException {
        StringWriter out = new StringWriter();
        PersonWriter.writePerson(out, bobSmith, LFM);
        assertEquals("Smith, Bob", out.toString());
    }

    @Test
    public void testPersonWriter() throws IOException {
        StringWriter out = new StringWriter();
        PersonWriter.writePerson(out, jennyJJones, FML);
        assertEquals("Jenny J Jones", out.toString());
    }

    @Test
    public void testPersonBobSmithFML() throws IOException {
        StringWriter out = new StringWriter();
        PersonWriter.writePerson(out, bobSmith, FML);
        assertEquals("Bob Smith", out.toString());
    }
}
