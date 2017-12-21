package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.movingObjects.MovingObject;
import mazeRunner.model.weapons.Weapon;

public interface IRunner extends MovingObject {
	
	public void moveUp();

	public void moveDown();

	public void moveRight();

	public void moveLeft();

	public void setSpeedState(SpeedState speedState);

	public SpeedState getSpeedState();

	public void setHealth(int health);

	public int getHealth();

	public List<Weapon> getSupportedWeapons();

	public void setSupportedWeapons(List<Weapon> supportedWeapons);

	public Weapon hasWeapon(String WeaponName);
	
	public Weapon getCurrentWeapon();

	public void setCurrentWeapon(Weapon currentWeapon);
	
	public Weapon getNextWeapon();
	
	public Weapon getPrevWeapon();
}
