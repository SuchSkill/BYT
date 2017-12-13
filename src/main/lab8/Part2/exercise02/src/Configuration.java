package lab8.Part2.exercise02.src;

import java.util.*;

public class Configuration {
    public int interval;

    public int duration;

    public int departure;

    public void load(Properties props) throws ConfigurationException {
        String valueString = props.getProperty("interval");
        int value = Integer.parseInt(valueString);

        if (valueString == null) {
            throw new ConfigurationException("monitor interval");
        }
        if (value <= 0) {
            throw new ConfigurationException("monitor interval > 0");
        }
        interval = value;

        valueString = props.getProperty("duration");
        if (valueString == null) {
            throw new ConfigurationException("duration");
        }
        value = Integer.parseInt(valueString);
        if (value <= 0) {
            throw new ConfigurationException("duration > 0");
        }
        if ((value % interval) != 0) {
            throw new ConfigurationException("duration % interval");
        }
        duration = value;

        valueString = props.getProperty("departure");
        if (valueString == null) {
            throw new ConfigurationException("departure offset");
        }
        value = Integer.parseInt(valueString);
        if (value <= 0) {
            throw new ConfigurationException("departure > 0");
        }
        if ((value % interval) != 0) {
            throw new ConfigurationException("departure % interval");
        }
        departure = value;
    }
}
