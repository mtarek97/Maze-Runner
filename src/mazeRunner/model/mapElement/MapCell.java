package mazeRunner.model.mapElement;
/**
 * 
 * @author ABDelRAHMAN
 *
 */
public interface MapCell extends IChangeable , IObserver{
	
	
	/**
	 * tells the state of the object
	 * @return true if obstacle ( any wall or bomb ) false otherwise 
	 */
	public boolean isObstacle();
	
	/**
	 * tells if this cell is an empty way  
	 * --i could have made one method that returns some integer denotes the state of the cell
	 * --for example 1 for non-obstacles , 0 for empty ways and so on
	 * --but i think this way is better because it separates the usually called method isWay
	 * @return true if empty way false otherwise
	 */
	public boolean isWay();
	/**
	 * returns the state of the obstacle if it was hit by bullet or bomb
	 * @return true if it can be destroyed
	 */
	public boolean isDestroyable();
	
	/**
	 * destroy the object to normal way ,, if way destroys it to hole 
	 * @return the resulted mapcell
	 */
	public MapCell Destroy();

	/**
	 * change the visual resource from the abstract factory class to the damaged one
	 * @param direction an integer from 0 to 8 represents the direction of the bomb
	 * 			0 means that this object is bomb and it has exploded ,, then the method replace it with fully destroyed empty way
	 * 			1 up , 2 top right corner , 3 right , and so on
	 * 			the visual effect must be suitable to the direction 
	 * @param fullDamage  tells that the bomb's power is very big and this cell was very close to the bomb so 
	 * 						it must be fully damaged 
	 */
	public void addBombVisualEffects(int direction , int fullDamage );
	/**
	 * changes the visual effect to that with bullets
	 * @param num the number of bullets     -- just in case we added weapons like shotgun which fires more than one bullet
	 */
	public void addBulletsVisualEffect(int num);
	/**
	 * the sound is shared among all the cells of the same kind using the abstract factory
	 * @return the shared sound null  if undestroyable     -- unsure about the return type //TODO
	 */
	public String getDestroyingSound();
	/**
	 * if an object was hit by the runner that sound should be played
	 * @return
	 */
	public String getHittingSound();
	/**
	 * the damage when hitting this object
	 * @return 0 for such nonObsticles and walls
	 */
	public int getDamage();
	public int getHealth();
	public void setHealth(int health);
	
	/*TODO add setters and getters for the resources*/
	/*TODO complete theme1 to test */
	/*TODO */


	
}
