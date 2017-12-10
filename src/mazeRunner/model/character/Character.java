package mazeRunner.model.character;

public interface Character {

	public void setSpeed(int speed);
	
	public int getSpeed();
	
	public void setDirection(int direction);
	
	public int getDirection();
	
	public void moveUp();
	
	public void moveDown();
	
	public void moveRight();
	
	public void moveLeft();
}
