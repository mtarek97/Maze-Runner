package mazeRunner.model.movingObjects.monsters;

import java.awt.Point;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.utilities.GameContract;

public abstract class Monster implements IMonster{
	private int speed;
	private int direction;
	private Point position;
	// position on runner layer
	private Point mappedPosition;
	private int health;
	protected IMonsterBehavior behavior;
	//imageLink{UP, Down, Right, Left}
	private String imageLinks;
	protected Map map;

	public void setMap(Map map) {
		this.map = map;
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
		Point currentPosition = this.position;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x-1,currentPosition.y);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.UP;
	}

	@Override
	public void moveDown() {
		Point currentPosition = this.position;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x+1,currentPosition.y);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.DOWN;
	}

	@Override
	public void moveRight() {
		Point currentPosition = this.position;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x,currentPosition.y+1);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.RIGHT;
	}

	@Override
	public void moveLeft() {
		Point currentPosition = this.position;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x,currentPosition.y-1);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.LEFT;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
		
	}

	@Override
	public void move() {
		behavior.run();
	}

	@Override
	public String getImageLinks() {
		return imageLinks;
	}

	@Override
	public void setImageLinks(String imageLinks) {
		this.imageLinks = imageLinks;
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
