package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level6 extends Level{

	public Level6(){
		this.mapSize = new MapSize(20, 20);
		this.theme = 2;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.MEDIUM;
		this.numberOfCheckPoints = 2;
	}
}
