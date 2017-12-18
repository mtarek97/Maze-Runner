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
	protected String imageLinks;
	protected List<Weapon> supportedWeapons;
	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
		
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	public String getImageLinks() {
		return imageLinks;
	}

	public void setPosition(Point position) {
		this.position = position;
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
        this.SetPosition(newPosition);
		this.direction = GameContract.Direction.UP;
	}

	@Override
	public void moveDown() {
        Point currentPosition = this.position;
        Point newPosition = new Point();
        newPosition.setLocation(currentPosition.x+1,currentPosition.y);
        this.SetPosition(newPosition);
	    this.direction = GameContract.Direction.DOWN;
	}

	@Override
	public void moveRight() {
        Point currentPosition = this.position;
        Point newPosition = new Point();
        newPosition.setLocation(currentPosition.x,currentPosition.y+1);
        this.SetPosition(newPosition);
		this.direction = GameContract.Direction.RIGHT;
	}

	@Override
	public void moveLeft() {
        Point currentPosition = this.position;
        Point newPosition = new Point();
        newPosition.setLocation(currentPosition.x,currentPosition.y-1);
        this.SetPosition(newPosition);
		this.direction = GameContract.Direction.LEFT;
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
		Point truePosition = this.getPosition();
		int mapedRow = truePosition.x / 3;
		int mapedColumn = truePosition.y / 3;
		Point mapedPosition = new Point();
		mapedPosition.setLocation(mapedRow,mapedColumn);
		return mapedPosition;
		
	}

	
	@Override
	public List<Weapon> getSupportedWeapons() {
		return supportedWeapons;
	}

	@Override
	public void setSupportedWeapons(List<Weapon> supportedWeapons) {
		this.supportedWeapons = supportedWeapons;
	}

	@Override
	public String getLayer(){
		return "movingObjectsLayerPane";
	}
}
