package mazeRunner.controller;

import java.util.Arrays;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.util.Pair;
import mazeRunner.StartGame;
import mazeRunner.view.MainMenu;

/**
 * Created by Mustafa on 12/19/2017.
 */
public class CustemOrLevelController implements Runnable{
    private static CustemOrLevelController controller = new CustemOrLevelController();
    private MainMenu menu;
    private PlayingController playingController = new PlayingController();
    private CustomPlaying customPlaying = new CustomPlaying();
    private CustemOrLevelController(){
        this.menu = new MainMenu();

        menu.setMenuData(this.menuData);
    }

    public static CustemOrLevelController getController(){
        return controller;
    }

    private List<Pair<String, Runnable>> menuData= Arrays.asList(
            new Pair<String, Runnable>("Story", playingController),
            new Pair<String, Runnable>("Custom Game", customPlaying)
    );

    public MainMenu getMenu(){
        return this.menu;
    }

    public void addMenuOption(Pair<String, Runnable> option){
        this.menuData.add(option);
    }

    @Override
    public void run() {
        Pane rootPane = (Pane) this.getMenu().createContent();
        StartGame.rootPane.getChildren().setAll(rootPane);
    }
}
