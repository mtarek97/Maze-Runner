package mazeRunner.themes.theme1;


import mazeRunner.model.mapCells.Way;

public class Way1 extends Way{
	private final String standardImageLink ="mazeRunner.themes.theme1.media.images.land";


	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}
}
