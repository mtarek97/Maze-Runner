package mazeRunner.themes.theme1;

import mazeRunner.model.mapElement.IObserver;
import mazeRunner.model.mapElement.MapCell;
import mazeRunner.model.mapElement.NonObstacle;

public class Bullets1 extends NonObstacle{
	private final String DestroySound = "";
	private final String HittingSound = "";
	private  int health = 1;
	@Override
	public MapCell Destroy() {
		MapCell w1 = new Way1();
		CellFactory cf = new CellFactory();
		return cf.getFullObject(w1);
		
	}

	@Override
	public String getDestroyingSound() {
		return this.DestroySound;
	}

	@Override
	public String getHittingSound() {
		return this.HittingSound;
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public void setHealth(int health) {
		this.health=health;
	}



	@Override
	public void update(int direction, int fullDamage) {
this.addBombVisualEffects(direction, fullDamage);		
	}

}
