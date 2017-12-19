package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level3 extends Level{

	public Level3(){
		this.mapSize = new MapSize(30, 30);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.MEDIUM;
		this.numberOfCheckPoints = 2;
	}
}
