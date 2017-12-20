package mazeRunner.model.mapCells;

public interface IBombs {
	/**
	 * returns the type of the bomb - DECREASES_HEALTH OR DECREASES_SCORE -
	 * you can fined the integer in  the contract
	 */
	public int getBombType();

	/**
	 * returns the damage of the bomb(DECREASES_HEALTH type )
	 * if the bomb is different type : returns -1
	 */
	public int getBombDamage();

	/**
	 * returns the points to decrease from the score (DECREASES_SCORE type)
	 * it returns a positive integer .
	 * if the bomb of type damage : returns -1
	 */
	public int getBombScore();


}
