package mazeRunner.model.mapElement;
/**
 * 
 * @author ABDelRAHMAN
 *
 */
public interface MapCell {
	/**
	 * @return true if empty way false otherwise
	 */
	public boolean isWay();
	/**
	 * @return true if any kind of walls false Otherwise
	 */
	public boolean isWall();
	/**
	 * @return true if NonObstacle(Gifts) false otherwise
	 */
	public boolean isNonObstacle();
	/**
	 * @return true if Obstacle(bombs) false otherwise
	 */
	public boolean isObstacle();
	
	
	/**
	 * the destoyable Objects are bombs , destroyable walls and gifts
	 * @return true if it is destroyable 
	 */
	public boolean isDestroyable();
	
	/**
	 * returns the new MapCell after update
	 * @return the resulted mapcell
	 */
	public MapCell getUpdateResult();
	/**
	 * set the the imagelink with the one by ashes of this direction
	 * @param Direction
	 */
	public void setAshes(int Direction);
	/**
	 * it is designed to be called when any mapcell is hit by Something causes damage (bombs)
	 * 
	 * updates the situation of the current object based on he damage received(full damage) ,
	 * if that damage caused a change to the type of the cell , it will return true 
	 * then you can get the result from getUpdateResult();
	 * @param direction
	 * @param fullDamage
	 * @return true if there is data in getUpdateResult();
	 */
	public boolean update(int direction , int fullDamage);
	
	/**
	 * the sound is shared among all the cells of the same kind using the abstract factory
	 * @return the shared sound null  if undestroyable     
	 */
	public String getDestroyingSound();
	/**
	 * if an object was hit by the runner that sound should be played
	 * @return
	 */
	public String getHittingSound();
	/**
	 * the damage when hitting this object
	 * @return 0 for such nonObsticles and walls and the damage of other things
	 */
	public int getDamage();
	/**
	 * @return the health of such cell , if it was called and the object is way , it returns Integer.Max
	 */
	public int getHealth();
	/**
	 * @return the current image source
	 */
	public String getImageLink();
	
}
