package lab9;


public class StateCarry {
    private final String state;
    public StateCarry(String state) {
        this.state = state;
    }
    public String getSavedState() {
        return state;
    }
}