package mazeRunner.themes.christmasTheme;

import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;

public class SpaceDust extends Way {
	private final String ashes = "images/spaceTheme/ashes.png";

	@Override
	public String getImageLink() {
		return this.ashes;
	}
}
