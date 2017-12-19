package mazeRunner.themes.theme1;

import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;

public class SolidWall extends Wall{

	private final String standardImageLink ="images/wall.png";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.hit";
	@Override
	public boolean isDestroyable() {
		return false;
	}

	@Override
	public MapCell getUpdateResult() {
		return null;
	}

	

	@Override
	public boolean update(int fullDamage) {
		return false;
	}

	@Override
	public String getDestroyingSound() {
		return null;
	}

	@Override
	public String getHittingSound() {
		return this.hittingSound;
	}

	@Override
	public int getHealth() {
		return Integer.MAX_VALUE;
	}

	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}

}
