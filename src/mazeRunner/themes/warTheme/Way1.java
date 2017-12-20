package mazeRunner.themes.warTheme;


import mazeRunner.model.mapCells.Way;

public class Way1 extends Way{
	private final String standardImageLink ="images/land.jpg";


	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}
}
