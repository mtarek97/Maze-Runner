package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level13 extends Level{

	public Level13(){
		this.mapSize = new MapSize(34, 34);
		this.theme = 3;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.LOW;
		this.numberOfCheckPoints = 3;
	}
}
