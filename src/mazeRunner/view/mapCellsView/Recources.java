package mazeRunner.view.mapCellsView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class Recources {
    private static Recources recources = new Recources();
    private Recources(){

    }
    public static Recources getRecources(){
        return recources;
    }

    private HashMap<String,ImageView> pictures = new HashMap<>();

    public ImageView getImage(String path){
        if(pictures.containsKey(path)){
            ImageView imageView = new ImageView(pictures.get(path).getImage());
            imageView.setFitWidth(60);
            imageView.setFitHeight(60);
            return imageView;
        }
        ImageView imageView = new ImageView(new Image(getClass().getResource(path).toExternalForm()));
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        pictures.put(path,imageView);
        return imageView;
    }

}
