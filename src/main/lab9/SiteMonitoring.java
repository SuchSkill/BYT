package lab9;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sun.webkit.network.URLs.newURL;

public class SiteMonitoring implements Observable{
    URL address;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;
    public URLConnection getConnect() {
        return connect;
    }

    public void setConnect(URLConnection connect) {
        this.connect = connect;
    }

    List<MyObserver> observers = new ArrayList<>();
    private URLConnection connect;

    public SiteMonitoring(String urlAddress) throws IOException {
        this.address = newURL(urlAddress);
        connect = getConnection();

    }

    public SiteMonitoring(String urlAddress, URLConnection u) throws MalformedURLException {
        this.address = newURL(urlAddress);
        connect = u;

    }

    void start() throws Exception {

        long lastModifiedtime = connect.getLastModified();
        long currentTime = connect.getLastModified();
        while (true) {
            currentTime = connect.getLastModified();
            if(lastModifiedtime != currentTime){
                notifyObservers();
                lastModifiedtime = currentTime;
            }
            Thread.sleep(1000);
        }
    }

    public URLConnection getConnection() throws IOException {
        return address.openConnection();
    }

    @Override
    public void addObserver(MyObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(MyObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (MyObserver observer : observers) {
            observer.handleNotification(address.toString());
        }
    }

    @Override
    public String toString() {
        return "SiteMonitoring{" +
                "state='" + state + '\'' +
                '}';
    }

    public StateCarry save() throws MalformedURLException {
        System.out.println("Save");
        return new StateCarry(state);
    }
    public void restore(StateCarry s) {
        state = s.getSavedState();
        System.out.println("Restore: " + s);
    }
}
