package mazeRunner.themes.theme0;


import mazeRunner.model.GameSetting;
import mazeRunner.model.mapCells.Way;

public class CustomWay extends Way{
	private final String standardImageLink =GameSetting.getGameSetting().getCustomMapCellImageLink("CustomWay");;


	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}
}
