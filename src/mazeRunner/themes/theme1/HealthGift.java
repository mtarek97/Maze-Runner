package mazeRunner.themes.theme1;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;

public class HealthGift extends Gifts{
	private MapCell afterUpdate = null;
	private final String standardImageLink ="mazeRunner.themes.theme1.media.images.medicine";


	private final String destroySound = "";
	private final String hittingSound = "";
	private  int health = 1;
	private final int giftDamage = 0;
	

	@Override
	public String getDestroyingSound() {
		return this.destroySound;
	}

	@Override
	public String getHittingSound() {
		return this.hittingSound;
	}

	@Override
	public int getHealth() {
		return this.health;
	}




	@Override
	public boolean update(int fullDamage) {
		this.health -= fullDamage;
		if(this.getHealth()<=0){
			this.afterUpdate = new ashes();
			return true;
		}
		return false;
	}

	@Override
	public MapCell getUpdateResult() {
		return this.afterUpdate;
	}

	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}

	@Override
	public int getDamage() {
		return this.giftDamage;
	}

	@Override
	public boolean isCauseDamage() {
		return false;
	}



	
}
