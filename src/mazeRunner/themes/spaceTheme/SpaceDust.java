package mazeRunner.themes.spaceTheme;

import mazeRunner.model.mapCells.Ashes;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;

public class SpaceDust extends Ashes {
	private final String ashes = "images/spaceTheme/ashes.png";

	@Override
	public String getImageLink() {
		return this.ashes;
	}

	@Override
	public String getLayer() {
		// TODO Auto-generated method stub
		return null;
	}
}
