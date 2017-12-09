package mazeRunner.model.mapBuilder;

import mazeRunner.model.levels.ILevel;

public interface IMapBuilder {
	
	public Map getMap();

	public void setLevel(ILevel level);
}
