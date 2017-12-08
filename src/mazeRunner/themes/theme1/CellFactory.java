package mazeRunner.themes.theme1;



import mazeRunner.model.mapElement.ICellFactory;
import mazeRunner.model.mapElement.MapCell;
/**
 * waiting for common resources to apply  flyweight
 * i think all themes must have one factory but i want to apply it here for now 
 * @author ABDelRAHMAN
 */
public class CellFactory implements ICellFactory{
	
	@Override
	public MapCell getFullObject(MapCell cell) {
		return null;
	}



}
