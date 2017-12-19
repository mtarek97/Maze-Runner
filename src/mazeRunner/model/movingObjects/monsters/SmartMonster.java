package mazeRunner.model.movingObjects.monsters;

import mazeRunner.model.mapBuilder.Map;

import java.awt.*;

public class SmartMonster implements IMonsterBehavior {
    Map map;
    boolean[][] visited;
    Point initialPoint;

    public SmartMonster(Map map, Point point) {
        this.map = map;
        visited = new boolean[map.getCellsLayer().length][map.getCellsLayer()[0].length];
        initialPoint = point;
    }

    public void move(int x, int y) {
        if( y >= visited[0].length|| x >= visited.length|| x < 0|| y < 0|| visited[x][y] == true|| map.getCellsLayer()[x][y].isWay() == false) {
            return;
        }
        visited[x][y] = true;

        move(x + 1, y);
        move(x - 1, y);
        move(x, y + 1);
        move(x, y - 1);


    }

   @Override
    public void run() {
        move(this.initialPoint.x, this.initialPoint.y);
    }
}
