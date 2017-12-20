package mazeRunner.themes.spaceTheme;

import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;

public class SpaceDust extends Way {
	private final String ashes = "file:mazeRunner.themes.spaceTheme.media.images.ashes.png";

	@Override
	public String getImageLink() {
		return this.ashes;
	}
}
