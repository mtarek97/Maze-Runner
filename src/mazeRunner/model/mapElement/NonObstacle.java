package mazeRunner.model.mapElement;

import com.sun.javafx.scene.control.ControlAcceleratorSupport;

import mazeRunner.themes.theme1.Way1;

public  abstract class NonObstacle implements MapCell {


	
	@Override
	public boolean isObstacle() {
		return false;
	}
	@Override
	public boolean isWay(){
		return false;
	}
	@Override
	public boolean isDestroyable() {
		return true;
	}
	
	
}
