package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level14 extends Level{

	public Level14(){
		this.mapSize = new MapSize(36, 36);
		this.theme = 3;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.LOW;
		this.numberOfCheckPoints = 3;
	}
}
