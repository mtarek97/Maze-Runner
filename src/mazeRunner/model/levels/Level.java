package mazeRunner.model.levels;

import java.util.List;

import mazeRunner.model.utilities.ClassFinder;

public abstract class Level implements ILevel{

	protected MapSize mapSize;
	protected int theme;
	protected List<Class<?>> supportedMapCells;
	protected int obstacleCount;
	protected int nonObstacleCount;
	protected int runnerSpeed;
	
	@Override
	public MapSize getMapSize() {
		return mapSize;
	}
	
	
	@Override
	public int getTheme() {
		return theme;
	}
	
	@Override
	public void addSupportedMapCells(){
		supportedMapCells = ClassFinder.findAllClassesInPackage("mazeRunner.themes.theme".concat(String.valueOf(theme)));
	}
	
	@Override
	public List<Class<?>> getSupportedMapCells() {
		return supportedMapCells;
	}

	@Override
	public int getObstacleCount() {
		return obstacleCount;
	}


	@Override
	public int getNonObstacleCount() {
		return nonObstacleCount;
	}

	@Override
	public int getRunnerSpeed(){
		return runnerSpeed;
	}

}
