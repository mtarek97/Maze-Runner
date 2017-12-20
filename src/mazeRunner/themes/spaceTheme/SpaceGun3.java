package mazeRunner.themes.spaceTheme;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;
import mazeRunner.themes.theme1.ashes;

public class SpaceGun3 extends Gifts{
	private MapCell afterUpdate = null;
	private final String standardImageLink ="file:mazeRunner.themes.spaceTheme.media.images.gun3";
	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.giftdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.reload";
	private  int health = 2;
	private final int giftDamage = 0;
	private int bulletsNumber = 3 ;
	private int oneBulletDamage = 4 ;
	private Class<? extends Weapon> weapon ;

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

	@Override
	public int getGiftType() {
		return GameContract.GiftsTypes.WEAPON;
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
	public Class<? extends Weapon> getWeaponClass() {
		try {
			weapon = (Class<? extends Weapon>) Class.forName("mazeRunner.model.weapons.spaceGun3"); 
		} catch (ClassNotFoundException e) {
			return null;
		}
		return weapon; 
	}

	@Override
	public int getGivenHealth() {
		return 0;
	}

}

