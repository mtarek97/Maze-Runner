package mazeRunner.model.mapBuilder;

import mazeRunner.model.difficulty.MapSize;

public class Main {
    public static void main(String[] args) {
        MapSize map = new MapSize(7,7);
        MazeGenerator generator = new MazeGenerator(map);
      boolean[][] maze =  generator.generateMaze();
      for(int i = 0; i < maze.length; i++) {
          for(int j = 0; j < maze[0].length; j++) {
              System.out.print(maze[i][j]+" ");
          }
          System.out.println("");
      }
    }
}
