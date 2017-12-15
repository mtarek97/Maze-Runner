package mazeRunner.model.movingObjects.runners;

import java.awt.Point;
import java.util.List;

import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;

public abstract class Runner implements IRunner{

	private int speed;
	private int direction;
	private Point position;
	// position on runner layer
	private Point mappedPosition;
	private int health;
	// imageLink{UP, Down, Right, Left}
	protected String[] imageLinks;
	protected List<Class<? extends Weapon>> supportedWeapons;
	
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
	public void SetPosition(Point position) {
		this.position = position;
		
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void setHealth(int health) {
		this.health = health;
		
	}

	@Override
	public int getHealth() {
		return health;
	}


	@Override
	public String getImageLink() {
		return imageLinks[getDirection()-1];
	}

	@Override
	public void setImageLinks(String[] imageLinks) {
		this.imageLinks = imageLinks;
	}
	
	@Override
	public void setMappedPosition(Point mappedPosition) {
		this.mappedPosition = mappedPosition;
		
	}

	@Override
	public Point gettMappedPosition() {
		return mappedPosition;
		
	}

	public List<Class<? extends Weapon>> getSupportedWeapons() {
		return supportedWeapons;
	}

	public void setSupportedWeapons(List<Class<? extends Weapon>> supportedWeapons) {
		this.supportedWeapons = supportedWeapons;
	}
}
