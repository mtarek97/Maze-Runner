package mazeRunner.themes.christmasTheme;

import mazeRunner.model.mapCells.Way;

public class spaceGround extends Way{
	private final String standardImageLink ="images/spaceTheme/ground.jpg";


	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}
}