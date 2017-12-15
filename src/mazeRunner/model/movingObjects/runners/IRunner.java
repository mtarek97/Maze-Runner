package mazeRunner.model.movingObjects.runners;

import mazeRunner.model.movingObjects.MovingObject;

public interface IRunner extends MovingObject {
	
	public void setHealth(int health);
	
	public int getHealth();
	
}
