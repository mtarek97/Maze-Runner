package mazeRunner.model.levels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.utilities.ClassFinder;

public abstract class Level implements ILevel {

	protected MapSize mapSize;
	protected int theme;
	protected List<Class<?>> supportedMapCells;
	protected Map<String, Integer> supportedMapCellsCounts = new HashMap<>();
	protected int runnerSpeed;
	protected int numberOfCheckPoints;

	@Override
	public MapSize getMapSize() {
		return mapSize;
	}

	@Override
	public int getTheme() {
		return theme;
	}

	@Override
	public Map<String, Integer> getSupportedMapCellsCounts() {
		return supportedMapCellsCounts;
	}

	@Override
	public List<Class<?>> getSupportedMapCells() {
		return supportedMapCells;
	}

	@Override
	public int getRunnerSpeed() {
		return runnerSpeed;
	}

	protected void addSupportedMapCells() {
		String themeName = "";
		if(theme == 1){
			themeName = "warTheme";
		}else if(theme == 2){
			themeName = "spaceTheme";
		}else if(theme == 3){
			themeName = "christmasTheme";			
		}else{
			themeName = "customTheme";
		}
		supportedMapCells = ClassFinder
				.findAllClassesInPackage("mazeRunner.themes.".concat(themeName));
	}

	protected void setSupportedMapCellsCount() {
		for (Class<?> mapCell : supportedMapCells) {
			try {
				MapCell cell = (MapCell) mapCell.newInstance();
				if(cell.isObstacle()){
					supportedMapCellsCounts.put(mapCell.getName(), obstaclesCount());
				}else if(cell.isNonObstacle()){
					supportedMapCellsCounts.put(mapCell.getName(), nonObstaclesCount());
				}else if(cell.isWall() && cell.isDestroyable()){
					supportedMapCellsCounts.put(mapCell.getName(), destroyableWallsCount());
				}
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}

	private int destroyableWallsCount() {
		if(theme==0) {
			return mapSize.getHeight()/2;
		}
		return mapSize.getHeight()/(2*theme);
	}

	private int obstaclesCount() {
		if(theme==0) {
			return mapSize.getHeight()/3;
		}
		return mapSize.getHeight()/(3*theme);
	}

	private int nonObstaclesCount() {
		if(theme==0) {
			return (mapSize.getHeight()*4)/7;
		}
		return mapSize.getHeight()*4/(7*theme);
	}
	@Override
	public int getNumberOfCheckPoints() {
		return this.numberOfCheckPoints;
	}
}
