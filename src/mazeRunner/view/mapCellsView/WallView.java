package mazeRunner.view.mapCellsView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class WallView extends MapCellView{
    public WallView() {
        ImageView imageView = new ImageView(new Image(getClass().getResource("wall.png").toExternalForm()));
        this.getChildren().add(imageView);
        this.setPrefSize(20, 20);
    }
}
