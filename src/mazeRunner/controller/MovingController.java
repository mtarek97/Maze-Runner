package mazeRunner.controller;

import mazeRunner.model.mapBuilder.IMapBuilder;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class MovingController {
    private IMapBuilder mapBuilder;

    public MovingController(IMapBuilder mapBuilder) throws Exception {
        this.mapBuilder = mapBuilder;
    }

}
