package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.movingObjects.MovingObject;
import mazeRunner.model.weapons.Weapon;

public interface IRunner extends MovingObject {

	public void setSpeedState(SpeedState speedState);

	public SpeedState getSpeedState();

	public void setHealth(int health);

	public int getHealth();

	public List<Weapon> getSupportedWeapons();

	public void setSupportedWeapons(List<Weapon> supportedWeapons);

}
