package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level9 extends Level{

	public Level9(){
		this.mapSize = new MapSize(26, 26);
		this.theme = 2;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.MEDIUM;
		this.numberOfCheckPoints = 2;
	}
}
