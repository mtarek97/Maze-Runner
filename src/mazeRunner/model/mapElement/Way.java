package mazeRunner.model.mapElement;

public abstract class Way implements IMapCell {

	@Override
	public boolean isObstacle() {
		return false;
	}

	@Override
	public boolean isWay() {
		return true;
	}
	
	@Override
	public int getHealth() {
		throw new UnsupportedOperationException("making health for the ground is unsupported yet");
	}

	@Override
	public boolean isDestroyable() {
		return false;
	}
	@Override
	public String getDestroyingSound() {
		throw new UnsupportedOperationException("making the ground destroyable object is not supported yet");
	}

	@Override
	public String getHittingSound() {
		throw new UnsupportedOperationException("hitting the ground  is not supported yet");
	}

	@Override
	public int getDamage() {
		throw new UnsupportedOperationException("making the ground causes damages is not supported yet");//Flammable cells or something like that
	}
	@Override
	public IMapCell getUpdateResult() {
		return null;
	}
	@Override
	public boolean update(int direction, int fullDamage) {
		this.setAshes(direction);
		return false;
	}

}
