package mazeRunner.themes.theme0;

import mazeRunner.model.GameSetting;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.themes.theme1.ashes;

public class CustomDestroyableWall extends Wall{

	private MapCell afterUpdate = null;
	private final String standardImageLink =GameSetting.getGameSetting().getCustomMapCellImageLink("CustomDestroyableWall");;

	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.boxdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.hit";
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
	@Override
	public String getLayer(){
		return "cellsLayerPane";
	}
}
