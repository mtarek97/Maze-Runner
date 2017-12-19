package mazeRunner.themes.theme0;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.themes.theme1.ashes;

public class AKgift0 extends Gifts{
	private MapCell afterUpdate = null;
	private final String standardImageLink ="images/ak.jpg";
	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.giftdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.reload";
	private  int health = 2;
	/*the full damage from this gift ,,, ex) gift that gives three bullets each causes 1 damage ,, then fulldamage is 3*/
	private final int giftDamage = 10;
	@Override
	public boolean isCauseDamage() {
		return true;
	}

	@Override
	public MapCell getUpdateResult() {
		return null;
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
	public String getDestroyingSound() {
		return this.destroySound;
	}

	@Override
	public String getHittingSound() {
		return this.hittingSound;
	}

	@Override
	public int getDamage() {
		return this.giftDamage;
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}

}
