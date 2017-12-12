package mazeRunner.controller;

import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.MapSize;
import mazeRunner.model.mapBuilder.MapBuilder;
import mazeRunner.model.mapBuilder.MazeGenerator;
import mazeRunner.model.mapBuilder._2DArrayIterator;
import mazeRunner.view.GUI;
import mazeRunner.view.mapElemenentsView.Recources;

public class MainController {
    private static MainController controller = new MainController();
    private GUI gui = new GUI();
    private GameSetting setting = new GameSetting();
    private Recources recources = Recources.getRecources();
    private MainController(){}
    private MapBuilder builder = new MapBuilder();
    private Character runner = setting.getRunner();
    //TODO trying code with this need to be deleted
    //private MapSize map = new MapSize(20,20);
    //private MazeGenerator generator = new MazeGenerator(map);
    //private boolean[][] maze =  generator.generateMaze();
 //TODO   _2DArrayIterator mapIterator = new _2DArrayIterator(builder.getMap().getMapCellArray());
    public static MainController getController(){
        return controller;
    }


}
