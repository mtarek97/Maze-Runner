package mazeRunner.model.movingObjects.runners;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Pistol;
import mazeRunner.model.weapons.Weapon;

public abstract class Runner implements IRunner {

	private SpeedState speedState;
	private int direction;
	private Point positionInBigLayer;
	private int health = 100;
	protected String imageLinks;
	protected List<Weapon> supportedWeapons = new ArrayList<Weapon>() {
		{
			add(new Pistol(6, 3));
		}
	};
	private Weapon currentWeapon = supportedWeapons.get(0);

	@Override
	public SpeedState getSpeedState() {
		return speedState;
	}

	@Override
	public void setSpeedState(SpeedState speedState) {
		this.speedState = speedState;
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
		Point currentPosition = this.positionInBigLayer;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x - 1, currentPosition.y);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.UP;
	}

	@Override
	public void moveDown() {
		Point currentPosition = this.positionInBigLayer;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x + 1, currentPosition.y);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.DOWN;
	}

	@Override
	public void moveRight() {
		Point currentPosition = this.positionInBigLayer;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x, currentPosition.y + 1);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.RIGHT;
	}

	@Override
	public void moveLeft() {
		Point currentPosition = this.positionInBigLayer;
		Point newPosition = new Point();
		newPosition.setLocation(currentPosition.x, currentPosition.y - 1);
		this.setPosition(newPosition);
		this.direction = GameContract.Direction.LEFT;
	}

	/**
	 * in big layer
	 */
	@Override
	public void setPosition(Point position) {
		this.positionInBigLayer = position;

	}

	/**
	 * in big layer
	 */
	@Override
	public Point getPosition() {
		return positionInBigLayer;
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
	public String getImageLinks() {
		return imageLinks;
	}

	@Override
	public void setImageLinks(String imageLinks) {
		this.imageLinks = imageLinks;
	}
	Point PositionInSmall ;
	@Override
	public void setMappedPosition(Point mappedPosition) {

		this.PositionInSmall = mappedPosition;

	}
/**
 * in small
 */
	@Override
	public Point getMappedPosition() {
			Point smallpos = new Point(1,1);
			
			smallpos.setLocation(Math.floor(this.positionInBigLayer.getX()/3),Math.floor(this.positionInBigLayer.getY()/3));
			
			return smallpos;

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
	public String getLayer() {
		return "movingObjectsLayerPane";
	}

	@Override
	public Weapon hasWeapon(String weaponName) {
		for (Weapon weapon : getSupportedWeapons()) {
			if (weapon.getClass().getSimpleName().equals(weaponName)) {
				return weapon;
			}
		}
		return null;
	}

	@Override
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	@Override
	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}
	
	@Override
	public Weapon getNextWeapon(){
		int nextIndex = supportedWeapons.indexOf(currentWeapon) + 1;
		if(nextIndex < supportedWeapons.size()) {
			return supportedWeapons.get(nextIndex);
		}
		return currentWeapon;
		
	}
	
	@Override
	public Weapon getPrevWeapon(){
		int prevIndex = supportedWeapons.indexOf(currentWeapon) -1;
		if(prevIndex >= 0) {
			return supportedWeapons.get(prevIndex);
		}
		return currentWeapon;
	}
}
