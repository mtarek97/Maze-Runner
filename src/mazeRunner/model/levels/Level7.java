package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level7 extends Level{

	public Level7(){
		this.mapSize = new MapSize(22, 22);
		this.theme = 2;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.MEDIUM;
		this.numberOfCheckPoints = 2;
	}
}
