package lab8.edu.ncsu.monopoly;

public abstract class Cell implements IOwner {
	private boolean available = true;
	private String name;
	protected Player theOwner;

	public String getName() {
		return name;
	}

	@Override
	public Player getTheOwner() {
		return theOwner;
	}
	
	public int getPrice() {
		return 0;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	public abstract void playAction();

	@Override
	public void setAvailable(boolean available) {
		this.available = available;
	}

	void setName(String name) {
		this.name = name;
	}

	public void setTheOwner(Player theOwner) {
		this.theOwner = theOwner;
	}
    
    public String toString() {
        return name;
    }
}
