package lab9;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ChangeObserver implements MyObserver{
    @Override
    public void handleNotification(String site) {
        System.out.println(site + " modified on" + LocalTime.now());
    }
}
