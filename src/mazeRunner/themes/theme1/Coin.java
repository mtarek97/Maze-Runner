package mazeRunner.themes.theme1;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;

public class Coin extends Gifts {
	private MapCell afterUpdate = null;
	private final String standardImageLink ="mazeRunner.themes.theme1.media.images.Coin";

	private final String destroySound = "mazeRunner.themes.theme1.media.soundEffects.giftdestroy";
	private final String hittingSound = "mazeRunner.themes.theme1.media.soundEffects.coin";
	private  int health = 2;
	

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
		return 0;
	}

	@Override
	public boolean isCauseDamage() {
		return false;
	}



	
}
