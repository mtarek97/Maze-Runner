package mazeRunner.model.mapBuilder;

import java.awt.*;
import java.util.Arrays;

public class GetEndPoint {

   private boolean[][] visited;
   private boolean[][] maze;
   private Point end = new Point();
   private int maxEndPoint = -1;
    public GetEndPoint(boolean[][] maze) {
        this.maze = maze;
        visited = new boolean[maze.length][maze[0].length];
        //Arrays.fill(visited, Boolean.FALSE);
        solve(1, 1, 0);
    }
    public Point getEnd() {
        return end;
    }
    public void solve(int x, int y, int score) {
        if( y >= visited[0].length|| x >= visited.length|| x < 0|| y < 0|| visited[x][y] == true|| maze[x][y] == true) {
            return;
        }
        visited[x][y] = true;
        if(score > maxEndPoint){
            maxEndPoint = score;
            end.x = x;
            end.y = y;
        }
        solve(x + 1, y, score + 1);
        solve(x - 1, y, score + 1);
        solve(x, y + 1, score + 1);
        solve(x, y - 1, score + 1);
    }

}
