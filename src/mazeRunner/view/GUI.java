package mazeRunner.view;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mazeRunner.model.levels.MapSize;
import mazeRunner.model.mapBuilder.GetEndPoint;
import mazeRunner.model.mapBuilder.MazeGenerator;

/**
 * Created by Mustafa on 12/8/2017.
 */

public class GUI extends Application{
    MapSize map = new MapSize(20,20);
    MazeGenerator generator = new MazeGenerator(map);
    boolean[][] maze =  generator.generateMaze();
    Cell[][] cells = new Cell[41][41];
    Cell wall = new Cell();
    GetEndPoint end = new GetEndPoint(maze);
    int x = end.getEnd().x;
    int y = end.getEnd().y;
    int runnerX = 1;
    int runnerY = 1;
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane objectsPane = new GridPane();
        GridPane runnerPane = new GridPane();
        runnerPane.setStyle("-fx-background-color: transparent");
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == true){
                    Cell cell = new Cell();
                    objectsPane.add(cell, j,i);
                    cells[i][j] = cell;
                }
                else {
                    Cell cell = new Cell();
                    cell.setStyle("-fx-background-color: white");
                    objectsPane.add(cell, j,i);
                    cells[i][j] = cell;
                }
                if(i == x && j == y){
                    Cell cell = new Cell();
                    cell.setStyle("-fx-background-color: aqua");
                    objectsPane.add(cell, j,i);
                    cells[i][j] = cell;
                }
            }
        }
        Cell cell = new Cell();
        cell.setStyle("-fx-background-color: chartreuse");
        runnerPane.add(cell, 1,1);
        cells[1][1] = cell;
        Pane boarderBane = new Pane();
        boarderBane.getChildren().add(runnerPane);
        boarderBane.getChildren().add(objectsPane);

        Scene scene = new Scene(boarderBane);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                if(!cells[runnerX - 1][runnerY].getStyle().toString().equals("-fx-background-color: black")) {
                    objectsPane.getChildren().remove(cells[runnerX - 1][runnerY]);
                    objectsPane.add(cells[runnerX][runnerY], runnerY, runnerX - 1);
                    runnerX = runnerX - 1;
                }
            } else if (event.getCode() == KeyCode.DOWN) {
                if (!cells[runnerX + 1][runnerY].getStyle().toString().equals("-fx-background-color: black")) {
                    objectsPane.getChildren().remove(cells[runnerX + 1][runnerY]);
                    objectsPane.add(cells[runnerX][runnerY], runnerY, runnerX + 1);
                    runnerX = runnerX + 1;
                }
            } else if (event.getCode() == KeyCode.RIGHT) {
                if (!cells[runnerX ][runnerY+1].getStyle().toString().equals("-fx-background-color: black")) {
                    objectsPane.getChildren().remove(cells[runnerX][runnerY + 1]);
                    objectsPane.add(cells[runnerX][runnerY], runnerY + 1, runnerX);
                    runnerY = runnerY + 1;
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                if (!cells[runnerX ][runnerY-1].getStyle().toString().equals("-fx-background-color: black")) {
                    objectsPane.getChildren().remove(cells[runnerX][runnerY - 1]);
                    objectsPane.add(cells[runnerX][runnerY], runnerY - 1, runnerX);
                    runnerY = runnerY - 1;
                }
            }
            event.consume();
        });
        primaryStage.setTitle("try");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public class Cell extends Pane {
        public Cell() {
          //  ImageView imageView = new ImageView(new Image(getClass().getResource("move.png").toExternalForm()));
            //imageView.setFitWidth(20);
            //imageView.setFitHeight(20);
            //this.getChildren().add(imageView);
            setStyle("-fx-background-color: black");
            this.setPrefSize(20, 20);
        }

    }
   /* public Node getNodeByRowColumnIndex (int row, int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }*/
}
