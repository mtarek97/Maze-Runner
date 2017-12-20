package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level11 extends Level{

	public Level11(){
		this.mapSize = new MapSize(30, 30);
		this.theme = 3;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.LOW;
		this.numberOfCheckPoints = 3;
	}
}
