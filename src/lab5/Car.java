package lab5;

/**
 * Created by Eugene on 09-Nov-17.
 */
public class Car {
    private int wheels;
    private String color;

    public Car() {
    }

    public Car(Car r) {
        wheels=r.wheels;
        color=r.color;

    }
    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(final int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car [wheels = " + wheels + ", color = " + color + "]";
    }
}
