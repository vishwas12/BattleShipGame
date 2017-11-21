
public interface Subject {
	public void addObserver(MyObserver o);
	public void notifyAllObservers();
}
