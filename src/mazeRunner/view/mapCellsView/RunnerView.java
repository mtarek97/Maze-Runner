package mazeRunner.view.mapCellsView;

import javafx.scene.image.ImageView;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class RunnerView extends  MapCellView{
    public RunnerView() {
        setImage(new ImageView("C/Users/Mustafa/IdeaProjects/Maze-Runner/src/mazeRunner/themes/theme1/media/images/mainRunner.gif"));
        this.setPrefSize(20, 20);
    }
}
