package mazeRunner.themes.spaceTheme;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;
import mazeRunner.themes.warTheme.LandAshes;

public class SpaceHealthGift extends Gifts{
	private MapCell afterUpdate = null;
	private final String standardImageLink ="images/spaceTheme/health.png";


	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.giftdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.healthhit";
	private  int health = 1;
	private final int giftDamage = 0;
	private  int Givenhealth = 4;


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
			this.afterUpdate = new LandAshes();
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

	@Override
	public int getGiftType() {
		return GameContract.GiftsTypes.HEALTH;
	}

	@Override
	public Class<? extends Weapon> getWeaponClass() {
		return null;
	}

	@Override
	public int getBulletsNumber() {
		return 0;
	}

	@Override
	public int getOneBulletDamage() {
		return 0;
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getGivenHealth() {
		return this.Givenhealth;
	}



	
}
