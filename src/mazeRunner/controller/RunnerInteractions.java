package mazeRunner.controller;

import mazeRunner.model.mapBuilder.Map;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class RunnerInteractions {
    // TODO : implement interactions methods (connect view with model)
    // all data that you will need to perform the tast must be in map i sent that map from MovingController
    Map map;
    public RunnerInteractions(Map map){
        this.map = map;
    }

    public void update(){
        if(isThereAnAction()){
            performAction(getAction());
        }
    }

    private boolean isThereAnAction(){
        //get current runner maped position and see if there is any thing in that position
    }

    private void runnerGiftInterAction(){
        //runner gift interaction logic will be here
    }

    private void runnerBombInteraction(){
        //runner bomb interaction will be here
    }


    private void performAction(String action){
        //

    }



    private String getAction(){
        // return the name of action
    }
}
