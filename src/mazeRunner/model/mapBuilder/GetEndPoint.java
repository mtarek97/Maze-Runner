package mazeRunner.model.mapBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GetEndPoint {

   private boolean[][] visited;
   private boolean[][] maze;
   private Point end = new Point();
   private int maxEndPoint = -1;
   private ArrayList<Point> correctWay = new ArrayList<>();
    public GetEndPoint(boolean[][] maze) {
        this.maze = maze;
        visited = new boolean[maze.length][maze[0].length];
        //Arrays.fill(visited, Boolean.FALSE);
        solve(1, 1, 0, new ArrayList<Point>());
    }
    public Point getEnd() {
        return end;
    }
    public void solve(int x, int y, int score, ArrayList<Point> correctWay) {
        if( y >= visited[0].length|| x >= visited.length|| x < 0|| y < 0|| visited[x][y] == true|| maze[x][y] == true) {
            return;
        }
        visited[x][y] = true;
        correctWay.add(new Point(x, y));
        if(score > maxEndPoint){
            maxEndPoint = score;
            end.x = x;
            end.y = y;
            this.correctWay.clear();
            for(int i=0;i<correctWay.size();i++)
                this.correctWay.add(correctWay.get(i));
        }
        solve(x + 1, y, score + 1, correctWay);
        solve(x - 1, y, score + 1, correctWay);
        solve(x, y + 1, score + 1, correctWay);
        solve(x, y - 1, score + 1, correctWay);
        correctWay.remove(correctWay.size() - 1);
    }

    public ArrayList<Point> getCorrectWay() {
        return correctWay;
    }

}
