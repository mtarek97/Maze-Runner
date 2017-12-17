package mazeRunner.view.mapCellsView;

import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.Obstacle;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;
import mazeRunner.model.movingObjects.runners.Runner;
import mazeRunner.model.weapons.Pistol;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class MapCellViewFactory {
    //TODO monster view
    public  MapCellView getMapCellView(String object){
        if(object.equalsIgnoreCase("Way")){
            return  new WayView();
        }
        else  if(object.equalsIgnoreCase("Wall")){
            return  new WallView();
        }
        else  if(object.equalsIgnoreCase("Obstacle")){
            return  new BombView();
        }
        else  if(object.equalsIgnoreCase("Gifts")){
            return  new GiftView();
        }
        else  if(object.equalsIgnoreCase("Runner")){
            return  new RunnerView();
        }
        return  null;
    }
}
