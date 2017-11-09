package lab4.ex1;

/**
 * Created by Eugene on 26-Oct-17.
 */
public class Calculator {
    double initState;

    public Calculator(double result) {
        this.initState = result;
    }

    public Calculator sum(double i) {
        return new Calculator(initState +i);
    }

    public Calculator minus(double i) {
        return new Calculator(initState - i);
    }

    public Calculator multiply(double i) {
        return new Calculator(initState * i);
    }
    public Calculator devide(double i) {
        return new Calculator(initState / i);
    }
    public Calculator sout(){
        System.out.println(initState);
        return new Calculator(initState);
    }

}
