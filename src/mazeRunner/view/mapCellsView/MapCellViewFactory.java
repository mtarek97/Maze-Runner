package mazeRunner.view.mapCellsView;

import mazeRunner.model.mapCells.*;
import mazeRunner.model.movingObjects.*;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class MapCellViewFactory {
    public  MapCellView getMapCellView(Object object){
        if(object instanceof Way){
            return  new WayView();
        }
        else  if(object instanceof Wall){
            return  new WallView();
        }
        else  if(object instanceof Obstacle){
            return  new WallView();
        }
        else  if(object instanceof Gifts){
            return  new WallView();
        }
        else  if(object instanceof Runner){
            return  new WallView();
        }
        else  if(object instanceof Gun){
            return  new WallView();
        }
        return  null;
    }
}
