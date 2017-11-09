package lab5;

/**
 * Created by Eugene on 09-Nov-17.
 */
public class Main {
    public static void main(String[] args) {
        CarBuilder builder = Car.builder();
        Car car = builder.setColor("White").setWheels(5).build();
        Car car2 = builder.setColor("Black").setWheels(3).build();
        System.out.println(car);
        System.out.println(car2);
    }
}
