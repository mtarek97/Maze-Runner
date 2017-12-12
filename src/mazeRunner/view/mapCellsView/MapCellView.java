package mazeRunner.view.mapCellsView;

import javafx.scene.layout.Pane;

/**
 * Created by Mustafa on 12/10/2017.
 */
public abstract class MapCellView extends Pane{
    public MapCellView(){
        this.setPrefSize(20, 20);
    }
    public void setImage(javafx.scene.image.ImageView imageView){
        this.getChildren().add(imageView);
    }
}
