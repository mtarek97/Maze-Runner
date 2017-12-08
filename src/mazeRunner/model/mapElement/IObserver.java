package mazeRunner.model.mapElement;

public interface IObserver {
	/**
	 * updates the status of the observer based on the prameters
	 * @param direction
	 * @param fullDamage
	 */
public void update(int direction , int fullDamage);
}
