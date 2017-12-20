package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level4 extends Level{

	public Level4(){
		this.mapSize = new MapSize(16, 16);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.HIGH;
		this.numberOfCheckPoints = 1;
	}
}
