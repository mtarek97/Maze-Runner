package mazeRunner.controller;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Obstacle;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class RunnerInteractions {
    // TODO : implement interactions methods (connect view with model)
    // all data that you will need to perform the task must be in map i sent that map from MovingController
    Map map;
    MapCell runnerCell;
    public RunnerInteractions(Map map){
        this.map = map;
        
    }

    public void update(){
    	int runnerPositionX = map.getRunner().getMappedPosition().x;
    	int runnerPositionY = map.getRunner().getMappedPosition().y;
        runnerCell = map.getCellsLayer()[runnerPositionX][runnerPositionY];
        if(isThereAnAction()){
            performAction(getAction());
        }
    }

    private boolean isThereAnAction(){
        //get current runner mapped position and see if there is any thing in that position
    	return runnerCell instanceof Obstacle || runnerCell instanceof Gifts;
    }

    private void runnerGiftInterAction(){
        //runner gift interaction logic will be here
    }

    private void runnerBombInteraction(){
        //runner bomb interaction will be here
    }


    private void performAction(String action){
        //perform specific action based on its name
    	if(action == "BombAction"){
    		runnerBombInteraction();
    	}else if(action == "GiftAction"){
    		runnerGiftInterAction();
    	}

    }



    private String getAction(){
        // return the name of action
    	if(runnerCell instanceof Obstacle){
    		return "BombAction";
    	}else if(runnerCell instanceof Gifts){
    		return "GiftAction";
    	}
    	return null;
    }
}
