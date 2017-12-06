package mazeRunner.model.mapBuilder;

import mazeRunner.model.difficulty.Difficulty;

public interface IMapBuilder {
	
	public Map getMap();

	public void setDifficulty(Difficulty level);
}
