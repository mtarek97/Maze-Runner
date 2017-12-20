package mazeRunner.model.mapCells;


import mazeRunner.themes.warTheme.Way1;

public  abstract class Gifts implements MapCell,IGift {
	@Override
	public boolean isWall(){
		return false;
	}
	@Override

	public boolean isNonObstacle(){
		return true;
	}
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
	@Override
	public String getLayer(){
		return "cellsLayerPane";
	}

	
}
