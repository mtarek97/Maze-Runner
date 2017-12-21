package mazeRunner.view.mapCellsView;

import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
            return imageView;
        }
System.out.println(path);
        ImageView imageView = new ImageView(new Image(getClass().getResource(path).toExternalForm()));
        pictures.put(path,imageView);
        return imageView;
    }

}
