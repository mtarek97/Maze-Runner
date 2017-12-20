package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level10 extends Level{

	public Level10(){
		this.mapSize = new MapSize(28, 28);
		this.theme = 2;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.MEDIUM;
		this.numberOfCheckPoints = 2;
	}
}
