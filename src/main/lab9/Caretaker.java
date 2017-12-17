package lab9;

import java.util.ArrayList;

public class Caretaker {
    private ArrayList<StateCarry> mementos = new ArrayList<>();

    public void addMemento(StateCarry m) {
        mementos.add(m);
    }

    public StateCarry getMemento() {
        return mementos.get(0);
    }
}
