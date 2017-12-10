package mazeRunner.model.mapElement;


import mazeRunner.themes.theme1.Way1;

public  abstract class NonObstacle implements MapCell {
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
	
}
