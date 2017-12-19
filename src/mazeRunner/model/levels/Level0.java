package mazeRunner.model.levels;

import mazeRunner.model.GameSetting;
import mazeRunner.model.utilities.GameContract;

public class Level0 extends Level{

	public Level0(){
		// this is a custom level
		// all of its attributes based on user choice in game setting
		this.mapSize = calculateMapSize();
		this.theme = 0;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameSetting.getGameSetting().getCustomRunnerSpeed();
		this.numberOfCheckPoints = 1;
	}
	
	private MapSize calculateMapSize(){
		int difficulty = GameSetting.getGameSetting().getCustomDifficulty();
		if(difficulty==GameContract.Difficulty.EASY){
			return new MapSize(10, 10);
		}else if(difficulty==GameContract.Difficulty.MEDIUM){
			return new MapSize(30, 30);
		}else{
			return new MapSize(50, 50);
		}
	}
	
}
