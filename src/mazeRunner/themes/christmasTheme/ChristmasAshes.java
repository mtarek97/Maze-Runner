package mazeRunner.themes.christmasTheme;

import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;

public class ChristmasAshes extends Way {
	private final String ashes = "images/christmasTheme/ashes.png";

	@Override
	public String getImageLink() {
		return this.ashes;
	}
}
