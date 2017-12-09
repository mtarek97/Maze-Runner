package mazeRunner.model.levels;

import java.util.List;

import mazeRunner.model.utilities.ClassFinder;

public abstract class Level implements ILevel{

	private MapSize size;
	private int theme;
	private List<Class<?>> supportedMapCells;
	private int obstacleCount;
	private int nonObstacleCount;
	
	@Override
	public void setSize(MapSize size) {
		this.size = size;
	}
	
	@Override
	public MapSize getSize() {
		return this.size;
	}
	
	@Override
	public void setTheme(int theme) {
		this.theme = theme;
	}
	
	@Override
	public int getTheme() {
		return theme;
	}
	
	@Override
	public void setSupportedMapCells(){
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
	public void setObstacleCount(int obstacleCount) {
		this.obstacleCount = obstacleCount;
	}

	@Override
	public int getNonObstacleCount() {
		return nonObstacleCount;
	}

	@Override
	public void setNonObstacleCount(int nonObstacleCount) {
		this.nonObstacleCount = nonObstacleCount;
	}

}
