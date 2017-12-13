package lab8.edu.ncsu.monopoly;

public interface IOwner {
    Player getTheOwner();

    boolean isAvailable();

    void setAvailable(boolean available);
}
