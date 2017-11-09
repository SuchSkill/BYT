package lab4.ex2;

/**
 * Created by Eugene on 26-Oct-17.
 */
class StateContext {
    private Statelike myState;
    StateContext() {
        setState(new StateLowerCase());
    }


    void setState(final Statelike newState) {
        myState = newState;
    }

    public void writeName(final String name) {
        myState.writeName(this, name);
    }
}