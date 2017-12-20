package mazeRunner.themes.spaceTheme;

import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;

public class SpaceDust extends Way {
	private final String ashes = "images/ashes2.png";

	@Override
	public String getImageLink() {
		return this.ashes;
	}
}
