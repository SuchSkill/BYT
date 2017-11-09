package lab5;

/**
 * Created by Eugene on 09-Nov-17.
 */
public class CarBuilder {
    private Car car;

    public CarBuilder() {
        car = new Car();
    }
    public Car build() {
        return new Car(car);
    }
    public CarBuilder setColor(final String color) {
        car.setColor(color);
        return this;
    }
    public CarBuilder setWheels(final int wheels) {
        car.setWheels(wheels);
        return this;
    }
}