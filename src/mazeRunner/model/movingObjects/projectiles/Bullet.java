package mazeRunner.model.movingObjects.projectiles;

import java.awt.Point;

import mazeRunner.model.utilities.GameContract;

public class Bullet implements Projectile{

	private int speed;
	private int direction;
	private Point position;
	private Point mappedPosition;
	private String ImageLink = "images/bullet1.png";

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
		return ImageLink;
	}


	@Override
	public void setMappedPosition(Point mappedPosition) {
		this.mappedPosition = mappedPosition;

	}

	@Override
	public Point getMappedPosition() {
		Point smallpos = new Point(1,1);
		
		smallpos.setLocation(Math.floor(this.position.getX()/3),Math.floor(this.position.getY()/3));
		
		return smallpos;

	}

	@Override
	public String getLayer(){
		return "movingObjectsLayerPane";
	}
}
