package mazeRunner.controller;


import javafx.util.Pair;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.MapBuilder;
import mazeRunner.view.MainMenu;

import java.util.List;

public class MainController {
    //this controller will controle main menu actions
    private static MainController controller = new MainController();
    private MainController(){}
    public static MainController getController(){
        return controller;
    }
    private IMapBuilder mapBuilder = MapBuilder.createMapBuilder();
    private List<Pair<String, Runnable>> menuData;
}
