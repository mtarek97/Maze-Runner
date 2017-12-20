package mazeRunner.themes.warTheme;

import mazeRunner.model.mapCells.Ashes;
import mazeRunner.model.mapCells.Way;

public class ashes extends Ashes {
	
	private final String ashes = "images/ashes.png";

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
