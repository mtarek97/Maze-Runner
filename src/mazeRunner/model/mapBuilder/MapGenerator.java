package mazeRunner.model.mapBuilder;


import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.*;
import mazeRunner.themes.theme1.Bullets1;
import mazeRunner.themes.theme1.SolidWall;
import mazeRunner.themes.theme1.Way1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class MapGenerator {

	private MapCell[][] maze;
	private Map map;
	java.util.Map<String, Integer> mapElementType;
	int numberOfNeededBullets = 0;
	CellFactory factory = new CellFactory();
	Stack<Point> allFreeCells = new Stack<>();
	public MapGenerator(boolean[][] maze, Map map) {
		this.map = map;
		MapCell[][] solidWallAndWaysLayer = new MapCell[maze.length][maze[0].length];
		this.mapElementType = map.getLevel().getSupportedMapCellsCounts();
		this.maze = new MapCell[maze.length][maze[0].length];
		map.setCellsLayer(this.maze);
		GenerateCheckPoint.map = map;
		GenerateCheckPoint.generate();

		for (int i = 0; i < maze.length; i++) {

			for (int j = 0; j < maze[0].length; j++) {

				if (maze[i][j]) {

					this.maze[i][j] = new SolidWall();
					solidWallAndWaysLayer[i][j] = new SolidWall();

				}
				else {

					this.maze[i][j] = new Way1();
					solidWallAndWaysLayer[i][j] = new Way1();
					allFreeCells.add(new Point(i, j));

				}
			}
		}
		map.setSolidWallAndWaysLayer(solidWallAndWaysLayer);
	}

	public Point getRandomCell(Stack<Point> allFreeCells) {
		Collections.shuffle(allFreeCells);
		return new Point(allFreeCells.pop());

	}
	public Map generateMap() throws Exception {

		ArrayList<String> classesName = new ArrayList<>();
		for (int i = 0; i < map.getLevel().getSupportedMapCells().size(); i++) {
			classesName.add(map.getLevel().getSupportedMapCells().get(i).getName());
		}
		factory.setClasses(classesName);
		for (java.util.Map.Entry<String, Integer> entry : this.mapElementType.entrySet()) {
			MapCell cell = factory.getInstanceByClassName(entry.getKey());
			for (int i = 0; i < entry.getValue(); i++) {
				Point randomCell = getRandomCell(allFreeCells);
				maze[randomCell.x][randomCell.y] = cell;
				if (cell instanceof Obstacle || (cell instanceof Wall && cell.isDestroyable() == true)) {
					numberOfNeededBullets += cell.getHealth();
				}
			}
		}
		generateBulletsGift();
		return  map;
	}
	public void generateBulletsGift() throws Exception {
		Bullets1 initial = new Bullets1();
		numberOfNeededBullets = numberOfNeededBullets - initial.getDamage() * 6;
		int bulletsRunHas = 6*initial.getDamage();

		while (numberOfNeededBullets > 0) {
			MapCell cell =	factory.getGiftDestroysObstacles();
			DistributeRandomGifts randomGifts = new DistributeRandomGifts(maze, numberOfNeededBullets, bulletsRunHas);
			Point random = randomGifts.getRandomPoint();
			maze[random.x][random.y] = cell;
			numberOfNeededBullets = numberOfNeededBullets - cell.getDamage();
			bulletsRunHas += cell.getDamage();
		}
	}

}


