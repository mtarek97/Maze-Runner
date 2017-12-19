package mazeRunner.model.movingObjects.projectiles;

import mazeRunner.model.movingObjects.MovingObject;

public interface Projectile extends MovingObject{
	
	public void setSpeed(int speed);

	public int getSpeed();

    public void moveInTheSameDirection();

}
