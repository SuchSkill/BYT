package lab4.ex2;

/**
 * Created by Eugene on 26-Oct-17.
 */
class StateMultipleUpperCase implements Statelike {
    private int count = 0;

    @Override
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toUpperCase());
        // Change state after StateMultipleUpperCase's writeName() gets invoked twice
        if(++count > 1) {
            context.setState(new StateLowerCase());
        }
    }
}