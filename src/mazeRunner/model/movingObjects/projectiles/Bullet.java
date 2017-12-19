package mazeRunner.model.movingObjects.projectiles;

import java.awt.Point;

import mazeRunner.model.utilities.GameContract;

public class Bullet implements Projectile{

	private int speed;
	private int direction;
	private Point position;
	// position on runner layer
	private Point mappedPosition;
	//imageLink{UP, Down, Right, Left}
	private String imageLinks;

	@Override
	public void moveInTheSameDirection() {

		Point currentPosition = this.position;
		Point newPosition;

		if(this.direction == GameContract.Direction.UP) {
			newPosition = new Point(currentPosition.x-1,currentPosition.y);
		} else if(this.direction == GameContract.Direction.DOWN) {
			newPosition = new Point(currentPosition.x+1,currentPosition.y);
		} else if(this.direction == GameContract.Direction.LEFT) {
			newPosition= new Point(currentPosition.x,currentPosition.y + 1);
		} else if(this.direction == GameContract.Direction.RIGHT) {
			newPosition = new Point(currentPosition.x+1,currentPosition.y - 1);
		} else {
			newPosition = this.position;
		}

		this.setPosition(newPosition);

	}

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

	@Override
	public void setPosition(Point position) {
		this.position = position;

	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void setImageLinks(String imageLinks) {
		//TODO
	}

	@Override
	public String getImageLinks() {
		return imageLinks;
	}


	@Override
	public void setMappedPosition(Point mappedPosition) {
		this.mappedPosition = mappedPosition;

	}

	@Override
	public Point getMappedPosition() {
		return mappedPosition;

	}

	@Override
	public String getLayer(){
		return "movingObjectsLayerPane";
	}
}
