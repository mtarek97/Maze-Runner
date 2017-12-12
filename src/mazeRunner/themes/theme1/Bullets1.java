package mazeRunner.themes.theme1;

import mazeRunner.model.mapCells.DirectionContract;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Gifts;

public class Bullets1 extends Gifts{
	private MapCell afterUpdate = null;
	private final String standardImageLink ="mazeRunner.themes.theme1.media.images.bullets";


	private final String destroySound = "mazeRunner.themes.theme1.media.soundEffects.giftdestroy";
	private final String hittingSound = "mazeRunner.themes.theme1.media.soundEffects.gifthit";
	private  int health = 1;
	/*the full damage from this gift ,,, ex) gift that gives three bullets each causes 1 damage ,, then fulldamage is 3*/
	private final int giftDamage = 1;
	

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
		return true;
	}



	
}
