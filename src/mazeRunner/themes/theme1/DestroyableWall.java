package mazeRunner.themes.theme1;

import mazeRunner.model.mapCells.DirectionContract;

import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;

public class DestroyableWall extends Wall{

	private MapCell afterUpdate = null;
	private final String standardImageLink ="mazeRunner.themes.theme1.media.images.box";

	private final String destroySound = "mazeRunner.themes.theme1.media.soundEffects.boxdestroy";
	private final String hittingSound = "mazeRunner.themes.theme1.media.soundEffects.hit";
	private  int health = 1;
	
	@Override
	public boolean isDestroyable() {
		return true;
	}

	@Override
	public MapCell getUpdateResult() {
		return this.afterUpdate;
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
	public int getHealth() {
		return this.health;
	}

	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}

}
