package mazeRunner.model.levels;

import mazeRunner.model.GameSetting;

public class Level0 extends Level{

	public Level0(){
		// this is a custom level
		// all of its attributes based on user choice in game setting
		this.mapSize = GameSetting.getGameSetting().getCustomMapize();
		this.theme = 0;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameSetting.getGameSetting().getCustomRunnerSpeed();
		this.numberOfCheckPoints = 1;
	}
	
}
