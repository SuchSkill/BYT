package lab9;

import java.util.List;

public interface Observable {
    void addObserver( MyObserver o);
    void removeObserver(MyObserver o);
    void notifyObservers();

}
