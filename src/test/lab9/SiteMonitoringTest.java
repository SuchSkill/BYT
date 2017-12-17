package lab9;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import static com.sun.webkit.network.URLs.newURL;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class SiteMonitoringTest {
    static int i = 0;
    static long time = 1513520109000L;

    @Test
    public void lastModifiedTest() throws Exception {
        ChangeObserver changeObserver = new ChangeObserver();

        URLConnection urlConnection = Mockito.mock(URLConnection.class);
//        when(urlConnection.getLastModified()).thenReturn((long) 1);
        when(urlConnection.getLastModified()).thenAnswer(reverseMsg());
        SiteMonitoring pjatk = new SiteMonitoring("http://pjatk.edu.pl", urlConnection);
        pjatk.addObserver(changeObserver);
        pjatk.start();
    }
    private static Answer<Long> reverseMsg() {
        return invocation -> {
            i++;
            if (i%3==0)
                time += 1000000000L;
            return time;

        };
    }
    @Test
    public void caretakerTest() throws Exception {
        Caretaker caretaker = new Caretaker();
        SiteMonitoring pjatk = new SiteMonitoring("http://pjatk.edu.pl");
        pjatk.setState("state1");
        System.out.println(pjatk);
        pjatk.setState("state2");
        System.out.println(pjatk);
        caretaker.addMemento(pjatk.save());
        pjatk.setState("state3");
        System.out.println(pjatk);
        pjatk.restore(caretaker.getMemento());
        System.out.println(pjatk);





    }
}