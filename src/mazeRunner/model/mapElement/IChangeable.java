package mazeRunner.model.mapElement;

public interface IChangeable {
	/**
	 * add cell observing this changable object (bombs)
	 * @param observer
	 * @param ObservingDirection
	 * @return true if this object supports the functionality of being observable
	 */
	public boolean addObserver(IObserver observer , int ObservingDirection);
	public boolean removeObserver(IObserver observer);
	/**
	 * tells the observers that a the changeable object has changed
	 * @return
	 */
	public boolean notifyChanges();

}
