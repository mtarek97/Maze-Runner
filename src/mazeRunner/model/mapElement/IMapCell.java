package mazeRunner.model.mapElement;
/**
 * 
 * @author ABDelRAHMAN
 *
 */
public interface IMapCell {
	
	
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
	 * returns the new IMapCell after update
	 * @return the resulted mapcell
	 */
	public IMapCell getUpdateResult();

	public void setAshes(int Direction);
	/**
	 * it is designed to be called when any mapcell is hit by Something causes damage (bombs )
	 * 
	 * updates the situation of the current object based on he damage received ,
	 * if that damage changed this cell type to another one , it will return true 
	 * then you can get the result from getUpdateResult
	 * @param direction
	 * @param fullDamage
	 * @return
	 */
	public boolean update(int direction , int fullDamage);
	
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
	public String getImageLink();
	
	/*TODO add setters and getters for the resources*/
	/*TODO complete theme1 to test */
	/*TODO */


	
}
