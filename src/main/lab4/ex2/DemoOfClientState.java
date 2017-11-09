package lab4.ex2;

/**
 * Created by Eugene on 26-Oct-17.
 */
public class DemoOfClientState {
    public static void main(String[] args) {
        final StateContext sc = new StateContext();

        sc.writeName("Monday");
        sc.writeName("Tuesday");
        sc.writeName("Wednesday");
        sc.writeName("Thursday");
        sc.writeName("Friday");
        sc.writeName("Saturday");
        sc.writeName("Sunday");
    }
}