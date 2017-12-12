package mazeRunner.themes.theme1;

import mazeRunner.model.mapCells.Way;

public class ashes extends Way {
	private final String ashes = "mazeRunner.themes.theme1.media.images.ashes2";

	@Override
	public String getImageLink() {
		return this.ashes;
	}
}
