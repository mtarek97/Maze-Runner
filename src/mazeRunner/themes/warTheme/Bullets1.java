package mazeRunner.themes.warTheme;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;

public class Bullets1 extends Gifts {
	private MapCell afterUpdate = null;
	private final String standardImageLink ="images/bullets.png";


	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.giftdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.gifthit";
	private  int health = 1;
	/*the full damage from this gift ,,, ex) gift that gives three bullets each causes 1 damage ,, then fulldamage is 3*/
	private final int giftDamage = 0;
	private int bulletsNumber = 3 ;
	private int oneBulletDamage = 4 ;
	private int BulletsDamage = 12;

	public int getBulletsDamage() {
		return BulletsDamage;
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

	@Override
	public int getGiftType() {
		return GameContract.GiftsTypes.BULLETS;
	}

	@Override
	public Class<? extends Weapon> getWeaponClass() {
		return null;
	}

	@Override
	public int getBulletsNumber() {
		return this.bulletsNumber;
	}

	@Override
	public int getOneBulletDamage() {
		return this.oneBulletDamage;
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getGivenHealth() {
		return 0;
	}



	
}
