package mazeRunner.controller;

import mazeRunner.view.mapCellsView.BombView;
import mazeRunner.view.mapCellsView.BulletView;
import mazeRunner.view.mapCellsView.EmptyRunnerPosition;
import mazeRunner.view.mapCellsView.GateView;
import mazeRunner.view.mapCellsView.GiftView;
import mazeRunner.view.mapCellsView.MapCellView;
import mazeRunner.view.mapCellsView.RunnerView;
import mazeRunner.view.mapCellsView.WallView;
import mazeRunner.view.mapCellsView.WayView;

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
        else  if(object.equalsIgnoreCase("bullet")){
            return  new BulletView();
        } else  if(object.equalsIgnoreCase("Gate")){
            return  new GateView();
        }
        return  new EmptyRunnerPosition();
    }
}
