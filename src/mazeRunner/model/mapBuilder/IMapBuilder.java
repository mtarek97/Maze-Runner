package mazeRunner.model.mapBuilder;

import mazeRunner.model.levels.ILevel;
import mazeRunner.model.movingObjects.runners.IRunner;

public interface IMapBuilder {
	
	public Map getMap() throws Exception;

	public void setLevel(ILevel level);

	public Map getGeneratedMap();

}
