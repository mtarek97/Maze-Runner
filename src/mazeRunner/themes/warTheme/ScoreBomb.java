package mazeRunner.themes.warTheme;

import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Obstacle;
import mazeRunner.model.utilities.GameContract;

public class ScoreBomb extends Obstacle  {
	private MapCell afterUpdate = null;
	private final String standardImageLink ="images/Dynamite2.png";


	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.bombdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.bombdestroy";
	private  int health = 1;
	private int damageToScore = 3 ;
	

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
		return this.damageToScore;
	}

	@Override
	public int getBombType() {
		return GameContract.BombsTypes.DECREASES_SCORE;
	}

	@Override
	public int getBombDamage() {
		return -1;
	}

	@Override
	public int getBombScore() {
		return this.damageToScore;
	}



}
