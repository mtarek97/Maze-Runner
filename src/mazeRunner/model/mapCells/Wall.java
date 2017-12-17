package mazeRunner.model.mapCells;

public abstract class Wall implements MapCell {

	@Override
	public boolean isCauseDamage(){
		return false;
	}
	@Override
	public boolean isWall(){
		return true;
	}
	
	@Override

	public boolean isNonObstacle(){
		return false;
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
	public int getDamage() {
		return 0;
	}
	@Override
	public String getLayer(){
		return "solidWallAndWaysLayerPane";
	}
	
}
