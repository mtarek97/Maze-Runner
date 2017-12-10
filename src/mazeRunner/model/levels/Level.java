package mazeRunner.model.levels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mazeRunner.model.mapElement.NonObstacle;
import mazeRunner.model.mapElement.Obstacle;
import mazeRunner.model.mapElement.Wall;
import mazeRunner.model.utilities.ClassFinder;

public abstract class Level implements ILevel {

	protected MapSize mapSize;
	protected int theme;
	protected List<Class<?>> supportedMapCells;
	protected Map<String, Integer> supportedMapCellsCount = new HashMap<>();
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
	public Map<String, Integer> getSupportedMapCellsCounts() {
		return supportedMapCellsCount;
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
		supportedMapCells = ClassFinder
				.findAllClassesInPackage("mazeRunner.themes.theme".concat(String.valueOf(theme)));
	}

	protected void setSupportedMapCellsCount() {
		for (Class<?> mapCell : supportedMapCells) {
			Object mapCellInstance;
			try {
				mapCellInstance = mapCell.newInstance();
				if (mapCellInstance instanceof Wall) {
					if (((Wall) mapCellInstance).isDestroyable()) {
						supportedMapCellsCount.put(mapCell.getSimpleName(), destroyableWallsCount());
					}
				} else if (mapCellInstance instanceof Obstacle) {
					supportedMapCellsCount.put(mapCell.getSimpleName(), obstaclesCount());
				} else if (mapCellInstance instanceof NonObstacle) {
					supportedMapCellsCount.put(mapCell.getSimpleName(), nonObstaclesCount());
				}
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}

	private int destroyableWallsCount() {
		// TODO : we need some logic here
		return 5;
	}

	private int obstaclesCount() {
		// TODO : we need some logic here
		return 5;
	}

	private int nonObstaclesCount() {
		// TODO : we need some logic here
		return 5;
	}
}
