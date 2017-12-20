package mazeRunner.themes.christmasTheme;

import mazeRunner.model.mapCells.Way;

public class SnowGround extends Way{
	private final String standardImageLink ="images/christmasTheme/snow.jpg";


	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}
}