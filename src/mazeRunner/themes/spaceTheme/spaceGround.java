package mazeRunner.themes.spaceTheme;

import mazeRunner.model.mapCells.Way;

public class spaceGround extends Way{
	private final String standardImageLink ="images/saceTheme/ground.jpg";


	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}
}