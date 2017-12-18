package mazeRunner.model.mapBuilder;

import mazeRunner.model.mapCells.CheckPoint;

import java.awt.*;
import java.util.ArrayList;

public class GenerateCheckPoint {
 public static Map map;

    public static void setMap(Map map) {
        GenerateCheckPoint.map = map;
    }

    public static void generate() {
        ArrayList<Point> correctWay = map.getCorrectWay();
        for(int i = 1; i <= map.getLevel().getNumberOfCheckPoints();i++)
        {
            int factor = correctWay.size() / (map.getLevel().getNumberOfCheckPoints()+1);
            Point point = correctWay.get(i*(factor));
            map.getCellsLayer()[point.x][point.y] = new CheckPoint();
        }
    }
}
