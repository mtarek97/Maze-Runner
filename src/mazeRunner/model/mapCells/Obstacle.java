package mazeRunner.model.mapCells;

public abstract  class Obstacle implements MapCell ,IBombs{

	@Override
	public boolean isCauseDamage(){
		return false;
	}
	@Override
	public boolean isWall(){
		return false;
	}
	
	@Override

	public boolean isNonObstacle(){
		return false;
	}
	@Override
	public boolean isObstacle() {
		return true;
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
