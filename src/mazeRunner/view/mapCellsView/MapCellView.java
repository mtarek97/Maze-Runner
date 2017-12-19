package mazeRunner.view.mapCellsView;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Mustafa on 12/10/2017.
 */
public abstract class MapCellView extends Pane{
    public MapCellView(){
        this.setPrefSize(60, 60);
    }
    public void setImage(ImageView imageView){
        this.getChildren().add(imageView);
    }
}
