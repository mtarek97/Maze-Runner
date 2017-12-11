package mazeRunner.controller;

import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.MapSize;
import mazeRunner.model.mapBuilder.MazeGenerator;
import mazeRunner.view.GUI;
import mazeRunner.view.mapElemenentsView.Recources;

public class MainController {
    private static MainController controller = new MainController();
    private GUI gui = new GUI();
    private GameSetting setting = new GameSetting();
    private Recources recources = Recources.getRecources();
    private MainController(){}
    //TODO changing maze generator with map generator
    private MapSize map = new MapSize(20,20);
    private MazeGenerator generator = new MazeGenerator(map);
    private boolean[][] maze =  generator.generateMaze();

    public static MainController getController(){
        return controller;
    }

}
