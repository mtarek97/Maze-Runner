package mazeRunner.view.mapElemenentsView;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class WayView extends MapCellView{
    String path = new String();
    public void setPath(String path){
        this.path = path;
    }
    public WayView() {
        setStyle("-fx-background-color: white");
        this.setPrefSize(20, 20);
    }

}
