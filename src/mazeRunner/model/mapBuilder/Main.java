package mazeRunner.model.mapBuilder;

import mazeRunner.model.levels.Level1;
import mazeRunner.model.levels.Level2;
import mazeRunner.model.levels.MapSize;

public class Main {
    public static void main(String[] args) throws Exception {
        MapBuilder builer = new MapBuilder();
        builer.createMapBuilder();
        builer.setLevel(new Level2());
       Map map= builer.getMap();
       @SuppressWarnings("unused")
	MapSize mapl = new MapSize(7,7);
       System.out.println("");
   //   MazeGenerator generator = new MazeGenerator(map);
   /*   //boolean[][] maze =  generator.generateMaze();
      for(int i = 0; i < maze.length; i++) {
          for(int j = 0; j < maze[0].length; j++) {
              System.out.print(maze[i][j]+" ");
          }
          System.out.println("");
      }
     GetEndPoint end = new GetEndPoint(maze);
        System.out.println(end.getEnd().x);
        System.out.println(end.getEnd().y);
    */
    }
}
