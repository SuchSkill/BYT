package lab8.Part2.exercise02.src;

import java.util.*;

public class Configuration {
    public int interval;

    public int duration;

    public int departure;

    public void load(Properties props) throws ConfigurationException {
        interval = readInterval(props);

        int value = readDuration(props);
        isNegative(value);
        isMultipleOfInterval(value);
        duration = value;

        value = readDeparture(props);
        isNegative(value);
        isMultipleOfInterval(value);
        departure = value;
    }

    private int readDeparture(Properties props) throws ConfigurationException {
        int value;
        String valueString = props.getProperty("departure");
        if (valueString == null) {
            throw new ConfigurationException("departure offset");
        }
        value = Integer.parseInt(valueString);
        return value;
    }

    private void isMultipleOfInterval(int value) throws ConfigurationException {
        if ((value % interval) != 0) {
            throw new ConfigurationException("duration % interval");
        }
    }

    private void isNegative(int value) throws ConfigurationException {
        if (value <= 0) {
            throw new ConfigurationException("duration > 0");
        }
    }

    private int readDuration(Properties props) throws ConfigurationException {
        String valueString = props.getProperty("duration");
        if (valueString == null) {
            throw new ConfigurationException("duration");
        }
        return Integer.parseInt(valueString);
    }

    private int readInterval(Properties props) throws ConfigurationException {
        String valueString = props.getProperty("interval");
        int value = Integer.parseInt(valueString);
        if (value <= 0) {
            throw new ConfigurationException("monitor interval > 0");
        }
        return value;
    }
}
