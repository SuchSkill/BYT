package lab4.ex2;

/**
 * Created by Eugene on 26-Oct-17.
 */
class StateLowerCase implements Statelike {
    @Override
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toLowerCase());
        context.setState(new StateMultipleUpperCase());
    }
}