package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level8 extends Level{

	public Level8(){
		this.mapSize = new MapSize(24, 24);
		this.theme = 2;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.MEDIUM;
		this.numberOfCheckPoints = 2;
	}
}
