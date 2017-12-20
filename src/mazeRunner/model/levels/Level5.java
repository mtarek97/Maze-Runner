package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level5 extends Level{

	public Level5(){
		this.mapSize = new MapSize(18, 18);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.HIGH;
		this.numberOfCheckPoints = 1;
	}
}
