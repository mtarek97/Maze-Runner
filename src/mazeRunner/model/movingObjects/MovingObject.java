package mazeRunner.model.movingObjects;

public interface MovingObject {

	public void setSpeed(int speed);
	
	public int getSpeed();
	
	public void moveUp();
	
	public void moveDown();
	
	public void moveRight();
	
	public void moveLeft();
}
