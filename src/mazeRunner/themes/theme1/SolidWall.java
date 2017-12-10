package mazeRunner.themes.theme1;

import mazeRunner.model.mapElement.IMapCell;
import mazeRunner.model.mapElement.Wall;

public class SolidWall extends Wall{

	private final String standardImageLink ="";
	private  String currentImageLink = this.standardImageLink;

	/* from index 0 to 8 - Links to the images suitable for his direction*/
	private final String[] ashesImagesLink ={"","","","","","","","",""};
	private final String hittingSound = "";
	@Override
	public boolean isDestroyable() {
		return false;
	}

	@Override
	public IMapCell getUpdateResult() {
		return null;
	}

	@Override
	public void setAshes(int Direction) {
		this.currentImageLink = this.ashesImagesLink[Direction];
	}

	@Override
	public boolean update(int direction, int fullDamage) {
		this.setAshes(direction);
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
		return this.currentImageLink;
	}

}
