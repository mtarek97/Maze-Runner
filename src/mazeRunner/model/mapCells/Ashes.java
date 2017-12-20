package mazeRunner.model.mapCells;

public abstract class Ashes implements MapCell{

	@Override
	public boolean isCauseDamage() {
		return false;
	}

	@Override
	public boolean isWay() {
		return false;
	}

	@Override
	public boolean isWall() {
		return false;
	}

	@Override
	public boolean isNonObstacle() {
		return false;
	}

	@Override
	public boolean isObstacle() {
		return false;
	}

	@Override
	public boolean isDestroyable() {
		return true;
	}

	@Override
	public MapCell getUpdateResult() {
		return null;
	}

	@Override
	public boolean update(int fullDamage) {
		return false;
	}

	@Override
	public String getDestroyingSound() {
		return null;
	}

	@Override
	public String getHittingSound() {
		return null;
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public int getHealth() {
		return Integer.MAX_VALUE;
	}



}
