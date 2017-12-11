package mazeRunner.view.mapElemenentsView;

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
            return pictures.get(path);
        }
        ImageView imageView = new ImageView(new Image(getClass().getResource("move.png").toExternalForm()));
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        pictures.put(path,imageView);
        return imageView;
    }
}
