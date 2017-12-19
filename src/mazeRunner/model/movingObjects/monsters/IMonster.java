package mazeRunner.model.movingObjects.monsters;

import mazeRunner.model.movingObjects.MovingObject;

public interface IMonster extends MovingObject{

	public void setSpeed(int speed);

	public int getSpeed();


	public int getHealth();

	public int getDamage();

	public void setBehaviour();
	public void move();
}
