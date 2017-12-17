package lab9;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        SiteMonitoring siteMonitoring = new SiteMonitoring("http://pjatk.edu.pl");
        siteMonitoring.start();

    }
}
