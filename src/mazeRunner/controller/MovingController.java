package mazeRunner.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import mazeRunner.model.GameSetting;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.view.ViewBuilder;
import mazeRunner.model.utilities.GameContract;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class MovingController {
    private IMapBuilder mapBuilder;
    public MovingController(IMapBuilder mapBuilder) throws Exception {
        this.mapBuilder = mapBuilder;
    }
    private Map map = mapBuilder.getGeneratedMap();
    private Object[][] movingObjectsLayerArray = map.getMovingObjectsLayer();
    private MapCell[][] mapCellsArray = map.getCellsLayer();
    private MapCell[][] SolidWallAndWaysArray = map.getSolidWallAndWaysLayer();
    ViewBuilder playingView = ViewBuilder.getViewBuilder();
    Scene scene = playingView.getScene();
    IRunner runner = map.getRunner();
    private boolean isNestPositionAWall(Point newPosition){
        int row = newPosition.x;
        int column = newPosition.y;
        if(SolidWallAndWaysArray[row][column] instanceof Wall || mapCellsArray[row][column] instanceof  Wall){
            return true;
        }
        return false;
    }
    //TODO pictures rotation
    public void actionHandeling(){
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newPosition = new Point(currentMapedPosition.x-1,currentMapedPosition.y);
                if(!isNestPositionAWall(newPosition)) {

                    runner.moveUp();
                }
            } else if (event.getCode() == KeyCode.DOWN) {
                if (true) {

                }
            } else if (event.getCode() == KeyCode.RIGHT) {
                if (true) {

                }
            } else if (event.getCode() == KeyCode.LEFT) {
                if (true) {

                }
            }
            event.consume();
        });
    }
    private void setImageDirection(int newDirection){
        ImageView imageView = new ImageView(new javafx.scene.image.Image((runner.getImageLink())));
        for (int i = 1; i < newDirection; i++){
            imageView.setRotate(imageView.getRotate() + 90);
            File outputFile = new File("C:/Users/Mustafa/IdeaProjects/Maze-Runner/src/mazeRunner/themes/theme1/media/images");
            BufferedImage bImage = SwingFXUtils.fromFXImage(imageView.getImage(), null);
            try {
                ImageIO.write(bImage, "gif", outputFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
