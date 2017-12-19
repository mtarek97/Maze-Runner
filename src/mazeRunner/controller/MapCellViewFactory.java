package mazeRunner.controller;

import mazeRunner.view.mapCellsView.*;

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
        return  new EmptyRunnerPosition();
    }
}
