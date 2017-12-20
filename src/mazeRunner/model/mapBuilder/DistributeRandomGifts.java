package mazeRunner.model.mapBuilder;

import mazeRunner.model.mapCells.*;
import mazeRunner.themes.warTheme.SolidWall;
import mazeRunner.themes.warTheme.Way1;

import java.awt.*;
import java.util.Collections;
import java.util.Stack;

public class DistributeRandomGifts {
    private Point randomPoint;
    private int done = 0;
    private boolean[][] visited;
    private MapCell[][] maze;
    private int numberOfNeededBullets;
    private int bulletsRunHas;
    public DistributeRandomGifts(MapCell[][]maze, int numberOfNeededBullets, int bulletsRunHas) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
        this.numberOfNeededBullets = numberOfNeededBullets;
        this.bulletsRunHas = bulletsRunHas;
    }
    public  Point getRandomPoint() {
        Stack<Point> allFreeCells = new Stack<>();
        DFS(1,1, allFreeCells);
        Collections.shuffle(allFreeCells);
        while (allFreeCells.peek().x == 1&& allFreeCells.peek().y == 1) {
            Collections.shuffle(allFreeCells);
        }
        return allFreeCells.peek();
        
    }

    public void  DFS(int x, int y, Stack<Point> allFreeCells ) {

        if( y >= visited[0].length|| x >= visited.length|| x < 0|| y < 0|| visited[x][y] ||!(maze[x][y].isWay())|| maze[x][y] instanceof CheckPoint ) {
            return;
        }

        if (maze[x][y].isObstacle() || (maze[x][y].isWall() && maze[x][y].isDestroyable())) {
            if(bulletsRunHas - maze[x][y].getHealth() < 0){
                return;
            }
            bulletsRunHas = bulletsRunHas - maze[x][y].getHealth();
        }
        if(x != 1 || y != 1)
        allFreeCells.add(new Point(x, y));
        visited[x][y] = true;
        DFS(x + 1, y, allFreeCells);
        DFS(x - 1, y, allFreeCells);
        DFS(x, y + 1, allFreeCells);
        DFS(x, y - 1, allFreeCells);

    }
}
