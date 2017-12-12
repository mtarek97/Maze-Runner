package mazeRunner.model.movingObjects;

import mazeRunner.model.utilities.GameContract;

public class Monster implements Character{
	private int speed;
	private int direction;
	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setDirection(int direction) {
		this.direction = direction;
		
	}

	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public void moveUp() {
		this.direction = GameContract.Direction.UP;
		// TODO : implement movement
	}

	@Override
	public void moveDown() {
		this.direction = GameContract.Direction.DOWN;
		// TODO : implement movement
	}

	@Override
	public void moveRight() {
		this.direction = GameContract.Direction.RIGHT;
		// TODO : implement movement
	}

	@Override
	public void moveLeft() {
		this.direction = GameContract.Direction.LEFT;
		// TODO : implement movement
	}
}
