package mazeRunner.themes.warTheme;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.IGift;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;

public class Coin extends Gifts {
	private MapCell afterUpdate = null;
	private final String standardImageLink ="images/Coin.png";

	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.giftdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.coin";
	private  int health = 2;
	private final int giftDamage = 0;
	private int CoinsNum = 3 ;


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

	@Override
	public int getGiftType() {
		return GameContract.GiftsTypes.COIN;
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
		return this.CoinsNum;
	}

	@Override
	public int getGivenHealth() {
		return 0;
	}



	
}
